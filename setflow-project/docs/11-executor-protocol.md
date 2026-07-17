# 11 — Protocolo do Executor

## 1. Missão

O Executor implementa a entrega ativa com precisão, preservando regras, arquitetura, dados e capacidade de validação. Ele é responsável pelo código e pelas provas técnicas, não pelo roadmap.

## 2. Pré-voo obrigatório

Antes de editar:

1. Ler `AGENTS.md`.
2. Ler a entrega completa.
3. Ler todas as referências citadas.
4. Inspecionar estrutura e estado do repositório.
5. Executar build ou teste baseline aplicável.
6. Identificar arquivos prováveis e riscos.
7. Confirmar que a entrega está `READY`.

Se o baseline já estiver quebrado, registrar evidência antes de alterar.

## 3. Regras de execução

- Implementar somente o escopo obrigatório.
- Não “aproveitar” para refatorar áreas não relacionadas.
- Preferir mudança mínima coerente à reescrita ampla.
- Preservar APIs existentes quando não houver requisito de mudança.
- Usar nomes do domínio definidos na documentação.
- Não acessar DAO diretamente da UI.
- Não introduzir estado crítico apenas em memória.
- Não usar `fallbackToDestructiveMigration` com dados reais.
- Não adicionar permissão Android fora do contrato.
- Não adicionar dependência sem justificar necessidade, versão e impacto.
- Não deixar dados mockados no fluxo de produção.

## 4. Implementação de dados

Ao alterar Room:

- incrementar schema quando necessário;
- criar migração;
- criar teste de migração;
- atualizar backup se o modelo exportado mudar;
- preservar snapshots e integridade referencial;
- revisar consultas e índices.

Ao alterar seed:

- validar schema e versão;
- manter importação idempotente ou exigir estratégia explícita;
- testar transação e rollback.

## 5. Implementação de UI

- Composable recebe estado e callbacks sempre que possível.
- ViewModel coordena regras e repositórios.
- Fornecer preview para componentes relevantes.
- Incluir semântica de acessibilidade.
- Tratar loading, vazio e erro.
- Evitar teclado em fluxo repetitivo de série.
- Não esconder ação destrutiva em gesto sem alternativa visível.

## 6. Cronômetro

- Usar `AppClock` injetável.
- Não persistir ticks.
- Calcular pelo deadline.
- Testar avanço do fake clock.
- Tratar pausa, retomada, ajuste e expiração idempotente.
- Não solicitar alarme exato no MVP.

## 7. Testes

A entrega deve incluir o menor conjunto suficiente para provar critérios e proteger regressões.

Prioridades:

1. Regra de domínio.
2. Persistência e migração.
3. ViewModel e estado.
4. UI crítica.
5. Fluxo manual descrito.

Fakes são preferidos a mocks frágeis para relógio e repositórios.

## 8. Validação

Executar os comandos definidos na entrega. Quando aplicável:

```bash
./gradlew lint
./gradlew test
./gradlew assembleDebug
```

Antes de release:

```bash
./gradlew connectedCheck
./gradlew assembleRelease
```

Não declarar sucesso de comando não executado. Se ambiente impedir, informar exatamente qual comando e erro.

## 9. Tratamento de ambiguidades

### Ambiguidade menor

Escolher a alternativa mais simples consistente e registrar no relatório.

### Ambiguidade material

Não implementar a parte conflitante. Reportar:

- pergunta;
- documentos envolvidos;
- opções;
- impacto de cada opção;
- recomendação técnica.

Continuar partes independentes quando seguro.

## 10. Formato obrigatório do relatório

```markdown
# Relatório — SF-XXX

## Resultado
COMPLETED | PARTIAL | BLOCKED

## Resumo
O que foi entregue.

## Arquivos alterados
- caminho: finalidade

## Decisões de implementação
- decisão e justificativa

## Critérios de aceite
- [x] critério
- [ ] critério pendente e motivo

## Testes executados
- comando — resultado

## Validação manual
- fluxo — resultado

## Migrações e dados
- impacto, versão e teste

## Dependências e permissões
- alterações ou “nenhuma”

## Riscos e limitações
- itens reais

## Fora do escopo identificado
- sugestões para backlog, sem implementação
```

## 11. Condições de bloqueio

- Regra conflitante sem precedência clara.
- Migração impossível sem decisão de produto.
- Dependência ausente que o contrato não autoriza adicionar.
- Falha de baseline que impede provar a entrega.
- Arquivo ou segredo necessário não disponível.

## 12. Proibições

- Responder apenas “feito”.
- Omitir teste falho.
- Alterar documentação para justificar código divergente sem aprovação.
- Apagar histórico para simplificar implementação.
- Desativar lint/teste para obter build verde.
- Incluir credenciais, chaves ou dados pessoais no repositório.
- Implementar itens pós-MVP por conveniência.
