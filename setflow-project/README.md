# SetFlow — documentação inicial do projeto

> Nome provisório: **SetFlow**  
> Plataforma inicial: Android nativo  
> Proprietário do produto: Douglas F. N. Morais  
> Estado: documentação de fundação, antes da implementação

## Objetivo

SetFlow é um aplicativo pessoal para registrar treinos de musculação com o menor atrito possível. O produto substitui anotações livres em bloco de notas por ações rápidas para registrar exercícios, séries, carga, repetições, RIR, técnicas intensificadoras, observações e descanso.

A primeira versão é local, sem conta e sem servidor. O plano atual de duas semanas de Douglas é a referência funcional e também será disponibilizado como carga inicial em `seed/initial-training-plan.json`.

## Leitura obrigatória

1. `docs/00-product-vision.md`
2. `docs/01-prd.md`
3. `docs/02-mvp-scope.md`
4. `docs/05-business-rules.md`
5. `docs/06-data-model.md`
6. `docs/07-technical-architecture.md`
7. `docs/08-ui-ux-specification.md`
8. `docs/09-backlog-and-roadmap.md`
9. `docs/10-orchestrator-protocol.md`
10. `docs/11-executor-protocol.md`

Os demais documentos complementam histórias, fluxos, testes, critérios de conclusão e lançamento.

## Estrutura

```text
.
├── AGENTS.md
├── README.md
├── docs/
│   ├── 00-product-vision.md
│   ├── 01-prd.md
│   ├── 02-mvp-scope.md
│   ├── 03-user-stories.md
│   ├── 04-user-flows.md
│   ├── 05-business-rules.md
│   ├── 06-data-model.md
│   ├── 07-technical-architecture.md
│   ├── 08-ui-ux-specification.md
│   ├── 09-backlog-and-roadmap.md
│   ├── 10-orchestrator-protocol.md
│   ├── 11-executor-protocol.md
│   ├── 12-testing-strategy.md
│   ├── 13-definition-of-done.md
│   ├── 14-release-checklist.md
│   └── adr/
├── seed/
│   └── initial-training-plan.json
└── references/
    ├── Plano_Treinos_Douglas_Semanas_1_e_2.txt
    └── Treinos_douglas_legado.docx
```

## Convenções

- Entregas técnicas usam o identificador `SF-###`.
- Requisitos funcionais usam `FR-###`.
- Requisitos não funcionais usam `NFR-###`.
- Regras de negócio usam `BR-###`.
- Histórias usam `US-###`.
- Decisões arquiteturais usam `ADR-###`.
- Toda mudança de escopo deve passar pelo Orquestrador.
- O Executor não deve criar requisitos por iniciativa própria.

## Próximo marco

O primeiro marco de implementação é `SF-001 — Inicialização do projeto Android`, descrito em `docs/09-backlog-and-roadmap.md`. Antes de executar qualquer entrega, o Orquestrador deve criar um cartão de trabalho usando o contrato definido em `docs/10-orchestrator-protocol.md`.
