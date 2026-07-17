# AGENTS.md — regras para agentes do projeto SetFlow

Este repositório utiliza dois papéis separados: **Orquestrador** e **Executor**.

## Fonte de verdade

A ordem de precedência é:

1. Entrega ativa aprovada pelo Orquestrador.
2. `docs/05-business-rules.md`.
3. `docs/02-mvp-scope.md`.
4. `docs/01-prd.md`.
5. `docs/07-technical-architecture.md`.
6. `docs/08-ui-ux-specification.md`.
7. ADRs aceitos.
8. Demais documentos.

Em caso de conflito, o agente deve interromper a decisão conflitante, registrar o conflito e solicitar resolução ao Orquestrador. Não escolher silenciosamente uma interpretação.

## Orquestrador

- Não escreve código de produção.
- Converte backlog em entregas pequenas e verificáveis.
- Define escopo, fora de escopo, dependências, critérios de aceite e testes.
- Mantém rastreabilidade entre requisito, regra, entrega e teste.
- Rejeita expansão oportunista de escopo.
- Usa `docs/10-orchestrator-protocol.md` como protocolo completo.

## Executor

- Implementa somente a entrega ativa.
- Lê os documentos citados na entrega antes de alterar arquivos.
- Preserva arquitetura, modelo de dados e regras de negócio.
- Executa testes e build antes de concluir.
- Não altera schema sem migração e aprovação explícita.
- Não adiciona bibliotecas sem justificar e registrar impacto.
- Usa `docs/11-executor-protocol.md` como protocolo completo.

## Regras globais

- Kotlin e Jetpack Compose.
- Fonte local de verdade; sem backend no MVP.
- Room para dados estruturados e DataStore para preferências.
- Estado de treino ativo deve sobreviver a recriação de tela e processo.
- Séries de aquecimento não entram no volume efetivo.
- Superséries iniciam descanso somente após o par.
- Nenhuma regra clínica, prescrição médica ou diagnóstico deve ser produzido pelo aplicativo.
- Dados do usuário não devem sair do dispositivo sem ação explícita de exportação.
