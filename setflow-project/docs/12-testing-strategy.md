# 12 — Estratégia de Testes

## 1. Objetivos

- Evitar perda de sessão e histórico.
- Provar regras de aquecimento, supersérie, técnica e progressão.
- Garantir cronômetro determinístico.
- Proteger migrações e restauração.
- Verificar que a interface principal continua rápida e utilizável.

## 2. Pirâmide

### Testes unitários

Maior volume. Cobrem:

- use cases;
- cálculos;
- validação;
- reducers/estado de ViewModel;
- serialização;
- fake clock.

### Testes de integração local

- DAOs com Room em memória.
- transações.
- migrações.
- repositórios.
- seed.
- backup e restauração.

### Testes de UI Compose

- fluxos críticos;
- semântica;
- estados vazio/erro;
- interação com steppers;
- supersérie;
- cronômetro com relógio controlado.

### Testes manuais

- uso real em aparelho.
- bloqueio de tela.
- processo encerrado.
- ergonomia com uma mão.
- som, vibração e tamanho de fonte.

## 3. Casos unitários obrigatórios

### Séries

- aquecimento não soma volume.
- série efetiva soma volume.
- carga/reps negativas são rejeitadas.
- copiar série gera novo ID.
- exercício unilateral soma lados corretamente.
- edição recalcula resumo.

### Supersérie

- concluir A não inicia descanso.
- concluir B inicia descanso.
- rodada vincula A e B pelo mesmo índice.
- rodada incompleta exige confirmação.
- volume permanece separado por exercício.

### Técnicas

- primeira técnica permitida não alerta.
- segunda técnica intensificadora alerta.
- técnica fora da última série alerta.
- exceção confirmada é persistida.
- supersérie não consome limite de intensificadora.

### Progressão

- 12/12/12 em faixa 8–12 gera candidato.
- 12/12/11 não gera.
- aquecimento é ignorado.
- flag de execução impeditiva bloqueia sugestão.
- RIR ausente não deve quebrar cálculo.
- incremento sugerido usa configuração do exercício.

### Cronômetro

- iniciar calcula deadline correto.
- avanço do fake clock reduz restante.
- pausa congela restante.
- retomar cria novo deadline.
- +15 e −15 respeitam mínimo zero.
- expiração acontece uma vez.
- reabrir recalcula pelo deadline.
- fallback por epoch após reboot simulado.

## 4. Testes de Room

- CRUD de cada agregado.
- ordem de blocos, exercícios e séries.
- sessão ativa completa.
- snapshot preservado após renomear exercício.
- arquivar exercício não remove histórico.
- transação de seed faz rollback em erro.
- finalização de sessão é atômica.
- cascatas não removem dados indevidos.
- consultas de último desempenho.

## 5. Migrações

Para cada versão N→N+1:

1. Criar base na versão N.
2. Inserir dados representativos.
3. Executar migração.
4. Validar schema.
5. Ler dados por DAOs da versão nova.
6. Verificar snapshots e relações.

Nunca substituir teste de migração por banco destrutivo.

## 6. Seed

- JSON válido.
- `schemaVersion` suportado.
- duas semanas.
- cinco treinos por semana.
- superséries com pares corretos.
- faixas de descanso coerentes.
- técnica opcional ligada ao exercício correto.
- reimportação não duplica silenciosamente.
- erro no meio da importação não deixa registros.

## 7. Backup

- round-trip: exportar, limpar base de teste, restaurar, comparar.
- arquivo truncado.
- JSON malformado.
- versão futura não suportada.
- referências ausentes.
- arquivo acima do limite definido.
- restauração falha preserva base anterior.
- CSV contém cabeçalhos e valores esperados.

## 8. UI crítica

- iniciar treino do dia.
- registrar série sem teclado.
- copiar série.
- registrar unilateral.
- executar supersérie.
- ajustar cronômetro.
- recuperar sessão.
- finalizar e abrir histórico.
- exportar backup pelo gateway fake.

Usar `testTag` somente quando semântica/texto não oferecer seletor estável e acessível.

## 9. Matriz de dispositivos

### Emuladores mínimos

- API 26: compatibilidade mínima.
- API 30: geração intermediária.
- API 33: permissões modernas de notificação.
- API 36: target baseline.

### Aparelho real

- aparelho pessoal principal de Douglas;
- teste com bateria otimizada e bloqueio de tela;
- escala de fonte padrão e aumentada.

## 10. Qualidade estática

- Android Lint.
- warnings novos avaliados.
- formatação padronizada.
- análise de dependências e permissões.
- recursos de texto fora de código.

Ferramenta adicional de lint só entra por entrega/ADR, não por improviso.

## 11. Dados de teste

Criar builders/factories para:

- treino normal;
- supersérie;
- unilateral;
- sessão incompleta;
- sessão com técnica;
- histórico com progressão;
- timer em cada estado.

Não usar dados pessoais reais em testes versionados.

## 12. Gates

### Por entrega

- testes relacionados verdes;
- build debug verde;
- lint sem novo erro impeditivo.

### Por sprint

- suíte unitária completa;
- integração Room;
- smoke UI.

### Por release

- todos os gates;
- connected tests;
- teste manual em aparelho;
- backup/restauração real;
- checklist de release concluído.
