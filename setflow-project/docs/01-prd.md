# 01 — PRD: Product Requirements Document

## 1. Resumo executivo

SetFlow é um aplicativo Android local-first para conduzir e registrar treinos de musculação. A interface deve reduzir digitação, apresentar o histórico no contexto do exercício e controlar descansos entre séries ou blocos de supersérie.

O plano inicial contém duas semanas alternadas, cinco treinos por semana, faixas variáveis de séries, repetições e descanso. O produto deve nascer capaz de representar esse plano sem codificá-lo de forma rígida.

## 2. Usuário e cenário principal

### Usuário primário

Douglas, praticante que já controla carga, repetições, séries, técnicas e observações, e valoriza descansos de aproximadamente 90 a 180 segundos.

### Cenário principal

1. Abrir o app na academia.
2. Selecionar o treino correspondente à semana do ciclo.
3. Executar exercícios na ordem planejada ou ajustada.
4. Registrar cada série rapidamente.
5. Acompanhar descanso.
6. Consultar último desempenho.
7. Finalizar e revisar resumo.

## 3. Metas do produto

- Reduzir o tempo e o número de interações para registrar séries.
- Estruturar o histórico de treino.
- Melhorar consistência de descanso.
- Apoiar progressão sem prescrever automaticamente.
- Registrar exceções reais: substituição, indisponibilidade, desconforto e alteração de volume.

## 4. Requisitos funcionais

### Programa e modelos

- **FR-001:** o app deve importar uma carga inicial de programa com duas semanas.
- **FR-002:** o usuário deve poder ativar, desativar e reiniciar o ciclo do programa.
- **FR-003:** o usuário deve poder escolher manualmente a semana ativa.
- **FR-004:** o app deve mostrar o treino previsto por dia da semana.
- **FR-005:** o usuário deve poder criar, duplicar, editar, reordenar e arquivar modelos.
- **FR-006:** alterações em modelos não devem modificar sessões históricas.
- **FR-007:** um modelo deve suportar aquecimento geral, foco, observações e blocos.
- **FR-008:** um bloco deve suportar execução normal ou supersérie.

### Exercícios

- **FR-009:** o usuário deve poder criar, editar e arquivar exercícios.
- **FR-010:** o exercício deve conter nome, aliases, grupo muscular, equipamento, lateralidade e observações.
- **FR-011:** o exercício pode ser substituído durante a sessão sem alterar automaticamente o modelo.
- **FR-012:** exercícios usados historicamente não podem ser excluídos fisicamente pela interface.

### Sessão

- **FR-013:** o usuário deve iniciar uma sessão a partir de modelo, repetição da última sessão ou treino livre.
- **FR-014:** apenas uma sessão pode permanecer ativa por vez.
- **FR-015:** o app deve recuperar automaticamente a sessão ativa após recriação de tela ou processo.
- **FR-016:** o usuário deve poder adicionar, remover, pular ou reordenar exercícios apenas na sessão.
- **FR-017:** a sessão deve preservar snapshots dos nomes, faixas e regras utilizadas no início.
- **FR-018:** o usuário deve finalizar ou cancelar uma sessão com confirmação.

### Séries

- **FR-019:** o usuário deve registrar série de aquecimento ou efetiva.
- **FR-020:** uma série deve aceitar carga, repetições, RIR, técnica e observação.
- **FR-021:** exercícios por lado devem aceitar valores iguais ou diferentes para esquerda e direita.
- **FR-022:** o usuário deve copiar a série anterior.
- **FR-023:** a primeira série deve poder reutilizar o último desempenho histórico.
- **FR-024:** o usuário deve editar ou excluir uma série antes e depois da conclusão da sessão.
- **FR-025:** o app deve mostrar faixa planejada e situação atual da série.
- **FR-026:** o usuário deve marcar falha, execução parcial, dor ou equipamento indisponível por etiquetas ou observação.

### Técnicas e superséries

- **FR-027:** o app deve registrar pelo menos `DROP_SET`, `REST_PAUSE`, `SUPERSET` e `NONE`.
- **FR-028:** o app deve alertar ao usar mais de uma técnica intensificadora na mesma sessão, sem bloquear definitivamente.
- **FR-029:** o app deve alertar quando drop set ou rest-pause for aplicado fora da última série prevista.
- **FR-030:** em supersérie, o app deve conduzir exercício A e B antes de iniciar o descanso do bloco.
- **FR-031:** o histórico deve preservar a relação entre séries que compõem a mesma rodada de supersérie.

### Descanso

- **FR-032:** concluir uma série deve oferecer início automático do descanso aplicável.
- **FR-033:** em supersérie, o descanso deve iniciar somente após concluir o último exercício da rodada.
- **FR-034:** o cronômetro deve permitir pausar, reiniciar, encerrar e ajustar em ±15 segundos.
- **FR-035:** o app deve mostrar duração sugerida, faixa mínima e máxima.
- **FR-036:** o cronômetro deve recalcular o restante após app voltar ao primeiro plano.
- **FR-037:** som e vibração devem ser configuráveis.
- **FR-038:** o MVP não deve solicitar permissão de alarme exato.

### Histórico e progressão

- **FR-039:** o histórico deve listar sessões por data, modelo, duração e status.
- **FR-040:** o detalhe deve mostrar exercícios, séries, volume e observações.
- **FR-041:** a tela de execução deve mostrar o último desempenho do exercício.
- **FR-042:** o app deve calcular volume apenas para séries efetivas válidas.
- **FR-043:** o app deve sinalizar candidato a progressão quando todas as séries efetivas atingirem o topo da faixa com execução considerada adequada.
- **FR-044:** a progressão deve ser sugestão; o app não deve aumentar carga automaticamente.
- **FR-045:** o usuário deve filtrar histórico por exercício e modelo.

### Configurações e dados

- **FR-046:** configurações devem incluir unidade, incremento de carga, descanso padrão, som, vibração, tema e manter tela ativa.
- **FR-047:** o usuário deve exportar backup JSON versionado.
- **FR-048:** o usuário deve importar backup com validação e confirmação.
- **FR-049:** o usuário deve exportar histórico em CSV.
- **FR-050:** o app deve permitir redefinir dados somente após confirmação reforçada.

## 5. Requisitos não funcionais

- **NFR-001 — Offline:** todas as funcionalidades do MVP devem operar sem internet.
- **NFR-002 — Desempenho:** telas principais devem responder imediatamente a ajustes de carga e repetições em aparelhos compatíveis.
- **NFR-003 — Persistência:** confirmação de série deve ser persistida antes de sinalizar sucesso definitivo.
- **NFR-004 — Recuperação:** sessão ativa deve sobreviver a rotação, processo encerrado e reabertura.
- **NFR-005 — Privacidade:** não transmitir dados sem ação explícita do usuário.
- **NFR-006 — Acessibilidade:** controles acionáveis devem possuir semântica, rótulo e área de toque adequada.
- **NFR-007 — Testabilidade:** relógio, repositórios e regras de domínio devem ser substituíveis por fakes.
- **NFR-008 — Manutenibilidade:** UI não acessa DAO ou DataStore diretamente.
- **NFR-009 — Integridade:** sessões históricas usam snapshots e não dependem de nomes atuais do catálogo.
- **NFR-010 — Compatibilidade:** `minSdk 26`; baseline inicial `compileSdk/targetSdk 36`, salvo ADR posterior.
- **NFR-011 — Localização:** textos devem ficar em recursos, começando em `pt-BR`.
- **NFR-012 — Segurança de arquivos:** importação deve validar schema, tamanho e conteúdo antes de substituir dados.

## 6. Requisitos de experiência

- Registrar série normal sem abrir teclado, quando valores sugeridos já existirem.
- Manter ações principais na metade inferior da tela.
- Exibir cronômetro de modo persistente durante descanso.
- Evitar modais para ações repetitivas.
- Diferenciar visualmente aquecimento, efetiva, concluída e pulada.
- Permitir correção imediata sem navegar para outra tela.
- Exibir somente informações necessárias durante a sessão; análises extensas ficam no histórico.

## 7. Carga inicial

O seed deve incluir:

- programa “Plano Douglas — Semanas 1 e 2”;
- cinco modelos por semana;
- descanso padrão derivado de cada faixa;
- exercícios unilaterais sinalizados;
- blocos de supersérie para braços;
- técnicas opcionais permitidas somente na última série indicada;
- aquecimentos e ênfases como notas do modelo;
- aliases relevantes encontrados no plano antigo.

## 8. Métricas de validação pessoal

- Mediana de interações para concluir uma série.
- Percentual de séries registradas sem teclado.
- Sessões concluídas sem recorrer ao bloco de notas.
- Erros ou perdas de sessão ativa.
- Uso do cronômetro por sessão.
- Percentual de exercícios com histórico consultado.
- Correções necessárias após finalizar o treino.

Essas métricas podem ser observadas manualmente no MVP; telemetria externa não será implementada.

## 9. Riscos

| Risco | Impacto | Mitigação |
|---|---:|---|
| Escopo crescer para plataforma fitness completa | Alto | Proteger `02-mvp-scope.md` e backlog pós-MVP |
| Cronômetro falhar em segundo plano | Alto | Persistir deadline, recalcular no retorno e testar bloqueio de tela |
| Modelo rígido não representar superséries | Alto | Entidade de bloco e rodada desde o primeiro schema |
| Histórico quebrar após edição de exercício | Alto | Snapshot em `SessionExercise` |
| Registro ficar mais lento que bloco de notas | Alto | Meta de poucos toques e testes de usabilidade reais |
| Mudança de schema causar perda de dados | Alto | Migrações obrigatórias e testes de backup |
| Carga inicial conter interpretação incorreta | Médio | Seed versionado, revisável e editável no app |

## 10. Dependências do MVP

- Android Studio e toolchain Kotlin compatível.
- Jetpack Compose e Material 3.
- Navigation 3 estável.
- Room estável.
- DataStore.
- Coroutines e Flow.
- Hilt ou DI definida pelo ADR técnico.
- API de seleção de documentos do Android para backup.

## 11. Questões já decididas

- Aplicativo Android nativo.
- Interface em Compose.
- Banco local estruturado.
- Sem autenticação e servidor.
- Plano atual como seed, não hardcode de UI.
- Avisos de regra são preferidos a bloqueios absolutos.

## 12. Questões para versões posteriores

- Nome e identidade visual final.
- Integração com Health Connect.
- Módulo de cardio.
- Módulo de nutrição resumida.
- Fotos e medidas corporais.
- Sincronização opcional e criptografada.
- Publicação na Play Store.
