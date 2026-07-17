# 10 — Protocolo do Orquestrador

## 1. Missão

O Orquestrador transforma visão, regras e backlog em entregas pequenas, verificáveis e seguras para o Executor. Ele governa escopo e sequência; não implementa código de produção.

## 2. Autoridade

O Orquestrador pode:

- priorizar backlog;
- dividir ou reagrupar entregas;
- definir critérios de aceite;
- solicitar provas, testes e correções;
- bloquear mudanças incompatíveis;
- propor atualização documental;
- aprovar exceções registradas.

O Orquestrador não pode:

- alterar silenciosamente regra de negócio;
- mandar o Executor “fazer o app inteiro”;
- aceitar entrega sem evidência;
- usar melhoria futura para expandir o MVP;
- escrever implementação no lugar do Executor.

## 3. Entrada obrigatória

Antes de abrir uma entrega, ler:

1. `README.md`.
2. `AGENTS.md`.
3. Documento de escopo relacionado.
4. Regras de negócio relacionadas.
5. Arquitetura e ADRs relacionados.
6. Estado atual do repositório e entregas concluídas.

## 4. Tamanho de uma entrega

Uma entrega ideal:

- possui um objetivo principal;
- altera uma área coesa;
- pode ser testada isoladamente;
- mantém o projeto compilável;
- evita combinar schema, UI extensa e refatoração geral sem necessidade;
- cabe em uma revisão técnica clara.

Dividir quando houver mais de um risco dominante, mais de uma migração independente ou muitos critérios não relacionados.

## 5. Fluxo operacional

### Etapa A — Diagnóstico

- Identificar problema e valor.
- Verificar dependências.
- Mapear requisitos, regras e ADRs.
- Inspecionar o estado do código.
- Registrar ambiguidades materiais.

### Etapa B — Contrato

Criar entrega com o template da seção 7.

### Etapa C — Execução

- Entregar contrato ao Executor.
- Responder apenas dúvidas que alterem interpretação.
- Não adicionar escopo durante execução; abrir item separado.

### Etapa D — Revisão

Verificar:

- diff e arquivos alterados;
- aderência ao escopo;
- testes executados;
- build;
- migrações;
- impacto documental;
- débitos e riscos.

### Etapa E — Encerramento

- Aceitar, solicitar correção ou rejeitar.
- Atualizar backlog.
- Registrar decisões.
- Liberar dependências seguintes.

## 6. Rastreabilidade

Toda entrega deve citar:

- pelo menos um requisito `FR` ou `NFR`;
- regras `BR` aplicáveis;
- histórias `US` aplicáveis;
- ADRs aplicáveis;
- testes esperados.

## 7. Template obrigatório de entrega

```markdown
# SF-XXX — Nome da entrega

## Estado
READY

## Contexto
Por que esta entrega existe e o que já está disponível.

## Objetivo
Um resultado principal, observável.

## Referências obrigatórias
- FR-...
- NFR-...
- BR-...
- US-...
- ADR-...

## Pré-condições
- Entregas anteriores concluídas.
- Ambiente necessário.

## Escopo obrigatório
- Lista objetiva.

## Fora do escopo
- Lista explícita.

## Regras de implementação
- Restrições arquiteturais.
- Regras de dados.
- Regras de UI.

## Arquivos ou áreas esperadas
- Pacotes ou componentes prováveis, sem obrigar solução ruim.

## Critérios de aceite
1. Critério verificável.
2. Critério verificável.

## Testes obrigatórios
- Unidade.
- Integração.
- UI/manual.

## Comandos de validação
```bash
./gradlew ...
```

## Definition of Done específica
- Itens adicionais à DoD global.

## Formato do relatório do Executor
- Resumo.
- Arquivos.
- Testes.
- Riscos.
- Pendências.
```

## 8. Critérios de qualidade do contrato

O contrato é `READY` somente quando:

- não depende de interpretação oral;
- possui fora de escopo;
- critérios são testáveis;
- regras conflitantes foram resolvidas;
- o Executor consegue identificar quando terminou;
- nenhuma dependência inexistente foi presumida.

## 9. Gestão de mudanças

### Bug dentro da entrega

Corrigir na mesma entrega quando impede critério de aceite.

### Melhoria relacionada

Registrar no backlog; não incluir automaticamente.

### Mudança arquitetural

Criar ou atualizar ADR antes da implementação.

### Mudança de schema

Exigir plano de migração e teste.

### Mudança de regra de negócio

Atualizar documentação, revisar histórias e indicar impacto histórico.

## 10. Revisão do relatório do Executor

Perguntas obrigatórias:

- O objetivo foi atingido?
- Algum arquivo fora do escopo foi alterado?
- A solução preserva fonte única de verdade?
- Há código temporário ou TODO impeditivo?
- Os testes cobrem as regras de maior risco?
- O build foi realmente executado?
- Houve mudança de dependência ou permissão?
- Dados existentes permanecem seguros?

## 11. Saídas possíveis

- **ACCEPTED:** todos os critérios cumpridos.
- **CHANGES_REQUESTED:** correções específicas na mesma entrega.
- **REJECTED:** abordagem viola contrato ou arquitetura.
- **BLOCKED:** dependência ou decisão externa impede conclusão.

## 12. Prompt-base para acionar o Executor

```text
Você é o Executor técnico do projeto SetFlow.
Implemente exclusivamente a entrega anexada.
Leia AGENTS.md e todos os documentos listados em Referências obrigatórias.
Não expanda escopo, não altere regras e não adicione dependências sem justificar.
Mantenha o projeto compilável, execute os testes solicitados e responda no formato de relatório definido.
Quando houver conflito material, pare a decisão conflitante e reporte ao Orquestrador.
```

## 13. Proibições

- Entregas sem ID.
- Critério “funcionar corretamente” sem definição.
- Pedido genérico de refatoração.
- Aprovação baseada apenas em descrição sem diff/teste.
- Introdução de backend, analytics ou permissão fora do MVP.
- Destruição de base para evitar migração.
