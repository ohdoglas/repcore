# 07 — Arquitetura Técnica

## 1. Baseline

- Android nativo.
- Kotlin.
- Jetpack Compose + Material 3.
- Aplicação single-activity.
- `minSdk 26`.
- Baseline inicial `compileSdk 36` e `targetSdk 36`.
- Gradle Kotlin DSL.
- Version Catalog em `gradle/libs.versions.toml`.
- JDK compatível com a versão estável do Android Gradle Plugin escolhida no `SF-001`.

Não usar SDK preview no primeiro release. Mudanças de API exigem ADR.

## 2. Bibliotecas e decisões

- Navigation 3 estável para back stack Compose.
- Room estável para dados relacionais locais.
- Preferences DataStore para configurações.
- Kotlin Coroutines e Flow.
- Hilt para injeção de dependência, salvo impedimento documentado no bootstrap.
- Kotlin Serialization para seed e backup JSON.
- Android Storage Access Framework para importar e exportar arquivos.
- JUnit e bibliotecas oficiais de teste do Compose.

Versões devem ser estáveis, compatíveis entre si e fixadas no version catalog. Não usar `+`, versões dinâmicas ou alpha sem ADR.

## 3. Arquitetura em camadas

```text
Compose Screen
    ↓ actions
ViewModel / UiState
    ↓ use cases
Domain
    ↓ repository interfaces
Data repositories
    ↓
Room / DataStore / Seed parser / Backup gateway
```

### UI

- Composables sem acesso direto a DAO.
- ViewModel por destino ou fluxo de tela.
- `UiState` imutável.
- Ações expressas por métodos ou intents tipados.
- Coleta de Flow com ciclo de vida.
- Estado efêmero de edição pode ficar em `rememberSaveable` quando não for crítico.

### Domínio

Use cases para regras com valor próprio:

- `StartWorkoutSessionUseCase`.
- `CompleteSetUseCase`.
- `CompleteSupersetRoundUseCase`.
- `StartRestTimerUseCase`.
- `FinishWorkoutUseCase`.
- `EvaluateProgressionUseCase`.
- `ImportInitialProgramUseCase`.
- `ExportBackupUseCase`.

Não criar use case que apenas repasse uma chamada sem agregar regra.

### Dados

- Repositório é a única porta para cada agregado.
- Room é fonte de verdade de programa, modelos, sessão e histórico.
- DataStore é fonte de verdade de preferências.
- Seed e backup entram por gateways próprios e validadores.
- Repositórios expõem `Flow` para leitura e `suspend` para comandos.

## 4. Estrutura de pacotes

```text
com.douglas.setflow
├── app/
│   ├── SetFlowApplication.kt
│   ├── MainActivity.kt
│   ├── navigation/
│   └── di/
├── core/
│   ├── common/
│   ├── clock/
│   ├── designsystem/
│   ├── model/
│   ├── database/
│   ├── datastore/
│   ├── backup/
│   └── testing/
├── domain/
│   ├── repository/
│   └── usecase/
└── feature/
    ├── home/
    ├── program/
    ├── exercises/
    ├── templates/
    ├── activeworkout/
    ├── history/
    └── settings/
```

Um único módulo `app` é suficiente no MVP. Pacotes devem permitir modularização posterior sem antecipá-la.

## 5. Estado e fluxo de dados

- Fluxo unidirecional.
- ViewModel expõe `StateFlow<UiState>`.
- UI envia ações.
- ViewModel executa regra e repositório.
- Persistência atualiza Flow.
- UI renderiza novo estado.

Eventos de navegação simples podem ser resultado de estado consumível ou callback do destino. Evitar canais de evento frágeis quando a mudança pode ser representada em estado.

## 6. Transações

Devem ser transacionais:

- importar seed;
- criar sessão e snapshots;
- concluir rodada de supersérie quando envolver múltiplas gravações;
- finalizar sessão e encerrar timer;
- restaurar backup;
- excluir sessão e dependências autorizadas.

## 7. Cronômetro

### Fonte de tempo

Definir interface:

```kotlin
interface AppClock {
    fun epochMillis(): Long
    fun elapsedRealtimeMillis(): Long
}
```

Produção usa `System.currentTimeMillis()` para datas civis e `SystemClock.elapsedRealtime()` para intervalos. Testes usam `FakeClock` controlável.

### Persistência

- Enquanto o aparelho não reinicia, `targetElapsedRealtimeMs` é a referência principal.
- `targetEpochMs` é fallback para recuperação após reinício.
- A UI atualiza a exibição por coroutine curta, mas a verdade é o deadline.
- Nenhum tick precisa ser persistido.
- Não solicitar `SCHEDULE_EXACT_ALARM` no MVP.

### Segundo plano

MVP garante:

- contagem correta quando o processo permanece vivo;
- recálculo correto ao voltar;
- recuperação após processo morto usando deadline persistido;
- feedback ao fim quando o app puder executá-lo.

Alerta absolutamente exato com processo suspenso não é requisito do MVP. Uma solução de foreground service ou integração de alarme exige ADR posterior por impacto em permissões e bateria.

## 8. Navegação

Destinos iniciais:

- `Home`.
- `Program`.
- `TemplateDetail(templateId)`.
- `ExerciseCatalog`.
- `ExerciseEditor(exerciseId?)`.
- `ActiveWorkout(sessionId)`.
- `WorkoutSummary(sessionId)`.
- `History`.
- `SessionDetail(sessionId)`.
- `ExerciseHistory(exerciseId)`.
- `Settings`.
- `DataManagement`.

Chaves de navegação devem ser serializáveis e tipadas.

## 9. Concorrência

- IO em dispatchers adequados fornecidos por DI.
- Não bloquear main thread.
- A conclusão de série deve impedir duplo toque com comando idempotente ou estado de envio.
- Repositórios devem serializar operações que disputem a sessão ativa.
- Importação e restauração bloqueiam comandos concorrentes de treino.

## 10. Tratamento de erros

Categorias:

- validação de entrada;
- persistência;
- arquivo inválido;
- versão incompatível;
- integridade referencial;
- erro inesperado.

UI deve apresentar mensagem acionável. Logs técnicos não devem exibir conteúdo sensível completo.

## 11. Backup e arquivos

- Usar seletor de documentos; não solicitar acesso amplo ao armazenamento.
- Gerar JSON UTF-8.
- Validar tamanho antes de carregar tudo em memória quando aplicável.
- Validar versão antes de desserializar grafo completo.
- Exportação CSV separada de backup.
- Nome sugerido: `setflow-backup-YYYYMMDD-HHmm.json`.

## 12. Segurança e privacidade

- Sem INTERNET permission no MVP, salvo dependência comprovada e ADR.
- Sem analytics remoto.
- Sem dados de saúde enviados a terceiros.
- Arquivos exportados ficam sob responsabilidade do destino escolhido pelo usuário.
- Evitar logs de observações, cargas e histórico em release.

## 13. Build e qualidade

Variantes:

- `debug`: logs e ferramentas de desenvolvimento.
- `release`: minificação conforme validação, sem logs sensíveis.

Comandos mínimos:

```bash
./gradlew lint
./gradlew test
./gradlew connectedCheck
./gradlew assembleDebug
./gradlew assembleRelease
```

`connectedCheck` pode ser executado em dispositivo/emulador disponível e é obrigatório antes de release, não necessariamente em cada microentrega.

## 14. Observabilidade local

- Logs estruturados somente em debug.
- Erros recuperáveis podem gerar entrada local de diagnóstico sem dados textuais sensíveis.
- Não implementar telemetria remota no MVP.

## 15. Referências oficiais

- Arquitetura Android: `https://developer.android.com/topic/architecture`
- Recomendações: `https://developer.android.com/topic/architecture/recommendations`
- Navigation 3: `https://developer.android.com/guide/navigation/navigation-3`
- Room: `https://developer.android.com/training/data-storage/room`
- DataStore: `https://developer.android.com/jetpack/androidx/releases/datastore`
- SystemClock: `https://developer.android.com/reference/android/os/SystemClock`
- Testes Compose: `https://developer.android.com/develop/ui/compose/testing`
