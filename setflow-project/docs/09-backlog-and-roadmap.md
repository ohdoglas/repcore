# 09 — Backlog e Roadmap

## 1. Política

Cada item abaixo é um objetivo de entrega, não uma ordem para implementar tudo de uma vez. O Orquestrador deve transformar cada item em contrato executável com escopo, critérios e testes.

Estados: `TODO`, `READY`, `IN_PROGRESS`, `BLOCKED`, `REVIEW`, `DONE`.

## 2. Roadmap do MVP

### Sprint 0 — Fundação documental

| ID | Entrega | Dependência | Resultado |
|---|---|---|---|
| SF-000 | Consolidar documentação | nenhuma | documentos e seed revisados |
| SF-001 | Inicializar projeto Android | SF-000 | projeto abre e compila |
| SF-002 | Configurar arquitetura, DI e navegação | SF-001 | destinos base e containers |
| SF-003 | Criar design system mínimo | SF-001 | tema, componentes e previews |

### Sprint 1 — Persistência e seed

| ID | Entrega | Dependência | Resultado |
|---|---|---|---|
| SF-010 | Implementar schema Room v1 | SF-002 | entidades, DAOs e database |
| SF-011 | Implementar DataStore | SF-002 | preferências persistidas |
| SF-012 | Implementar parser e validador do seed | SF-010 | JSON validado |
| SF-013 | Importar plano inicial transacionalmente | SF-012 | duas semanas navegáveis |
| SF-014 | Tela de programa e modelos somente leitura | SF-013 | plano visível |

### Sprint 2 — Catálogo e edição

| ID | Entrega | Dependência | Resultado |
|---|---|---|---|
| SF-020 | Catálogo de exercícios | SF-010 | listar, buscar e filtrar |
| SF-021 | Criar e editar exercício | SF-020 | formulário validado |
| SF-022 | Arquivar exercício | SF-020 | histórico preservado |
| SF-023 | Criar e editar modelo | SF-014, SF-021 | blocos e exercícios |
| SF-024 | Editar supersérie e reordenar | SF-023 | estrutura completa |

### Sprint 3 — Sessão e séries

| ID | Entrega | Dependência | Resultado |
|---|---|---|---|
| SF-030 | Iniciar sessão e criar snapshots | SF-013 | sessão `ACTIVE` |
| SF-031 | Recuperar sessão ativa | SF-030 | retomada após reabertura |
| SF-032 | Tela base de treino ativo | SF-030 | blocos e progresso |
| SF-033 | Registrar série comum | SF-032 | carga e reps persistidas |
| SF-034 | Aquecimento e séries efetivas | SF-033 | contagem correta |
| SF-035 | RIR, observações e flags | SF-033 | contexto de execução |
| SF-036 | Exercício unilateral | SF-033 | lados vinculados ou separados |
| SF-037 | Copiar e usar último desempenho | SF-033 | entrada rápida |
| SF-038 | Alterar ordem, pular e substituir | SF-032 | execução flexível |

### Sprint 4 — Condução do treino

| ID | Entrega | Dependência | Resultado |
|---|---|---|---|
| SF-040 | Motor de cronômetro com fake clock | SF-011, SF-033 | deadline persistido |
| SF-041 | UI do cronômetro | SF-040 | pausar e ajustar |
| SF-042 | Feedback sonoro e vibração | SF-041 | configuração respeitada |
| SF-043 | Execução de supersérie por rodadas | SF-033, SF-040 | descanso após par |
| SF-044 | Técnicas intensificadoras e alertas | SF-033 | exceções rastreadas |
| SF-045 | Finalizar e cancelar sessão | SF-040, SF-043 | status consistente |

### Sprint 5 — Histórico e progressão

| ID | Entrega | Dependência | Resultado |
|---|---|---|---|
| SF-050 | Lista e detalhe de sessões | SF-045 | histórico navegável |
| SF-051 | Histórico por exercício | SF-050 | últimas execuções |
| SF-052 | Volume efetivo | SF-050 | cálculo testado |
| SF-053 | Avaliar progressão dupla | SF-051, SF-052 | candidato a aumento |
| SF-054 | Resumo pós-treino | SF-052, SF-053 | feedback final |
| SF-055 | Editar sessão finalizada | SF-050 | correção rastreada |

### Sprint 6 — Dados, qualidade e release

| ID | Entrega | Dependência | Resultado |
|---|---|---|---|
| SF-060 | Exportar backup JSON | SF-050 | arquivo versionado |
| SF-061 | Restaurar backup | SF-060 | validação e rollback |
| SF-062 | Exportar CSV | SF-050 | análise externa |
| SF-063 | Redefinir dados | SF-061 | confirmação segura |
| SF-064 | Cobertura dos fluxos críticos | todas | testes e correções |
| SF-065 | Otimização de uso em academia | SF-064 | revisão prática |
| SF-066 | Gerar release pessoal v0.1.0 | SF-065 | APK assinada |

## 3. Prioridade interna

### P0

- Não perder sessão.
- Registrar série rapidamente.
- Cronômetro correto.
- Supersérie correta.
- Histórico e último desempenho.
- Backup restaurável.

### P1

- Treino livre.
- Duplicar modelo.
- Filtros.
- Recordes simples.
- Manter tela ligada.

### P2

- Gráficos.
- Cardio.
- Nutrição.
- Health Connect.
- Sincronização.

## 4. Pós-MVP

### Fase 2 — Análise

- Gráficos de carga, repetições e volume.
- Frequência por grupo muscular.
- Recordes e tendências.
- Deload e fadiga como registros, não prescrição.

### Fase 3 — Cardio

- Sessões por tempo, distância, velocidade, inclinação, resistência e frequência cardíaca informada.
- Integração opcional com Health Connect.

### Fase 4 — Nutrição resumida

- Metas diárias de calorias, proteínas, carboidratos, gorduras e água.
- Registro manual rápido, sem banco alimentar no primeiro corte.
- Correlação visual com treino e peso.

### Fase 5 — Evolução corporal

- Peso, medidas, fotos privadas e metas.
- Backup criptografado opcional.

## 5. Dependências críticas

- Schema de blocos deve existir antes da UI de supersérie.
- Fake clock deve existir antes de consolidar cronômetro.
- Snapshots devem existir antes do histórico.
- Backup só pode estabilizar depois do schema v1.
- Release exige restauração validada em base real de teste.

## 6. Registro de progresso

O Orquestrador deve manter um quadro com:

```text
ID:
Status:
Branch/PR:
Documentos afetados:
Migração:
Testes:
Riscos:
Decisão:
Próxima dependência liberada:
```
