# 03 — Histórias de Usuário

## Convenção

Prioridades: `P0` obrigatória, `P1` importante, `P2` posterior. Cada história deve ser ligada a uma entrega `SF-###` antes da implementação.

## Épico A — Primeiro uso e programa

### US-001 — Carregar plano inicial — P0

Como usuário, quero carregar o plano de duas semanas fornecido com o app para começar sem cadastrar cada treino manualmente.

**Aceite**

- O seed é importado apenas quando a base está vazia ou por ação explícita.
- As duas semanas e dez modelos aparecem corretamente.
- Uma segunda importação não duplica dados silenciosamente.

### US-002 — Escolher semana ativa — P0

Como usuário, quero selecionar a semana 1 ou 2 para seguir o ciclo mesmo quando meu calendário real tiver interrupções.

**Aceite**

- A semana ativa é persistida.
- Reiniciar ciclo volta à semana 1 após confirmação.
- O app não avança automaticamente sem regra configurada.

### US-003 — Ver treino do dia — P0

Como usuário, quero ver o treino previsto para o dia para iniciar rapidamente.

**Aceite**

- A tela inicial destaca o modelo correspondente ao dia e à semana ativa.
- É possível abrir outro modelo manualmente.

## Épico B — Exercícios e modelos

### US-004 — Cadastrar exercício — P0

Como usuário, quero cadastrar um exercício com equipamento e grupo muscular para reutilizá-lo em modelos.

### US-005 — Arquivar exercício — P0

Como usuário, quero arquivar um exercício sem apagar seu histórico.

### US-006 — Registrar aliases — P1

Como usuário, quero guardar nomes alternativos de puxadores e máquinas para encontrar o mesmo movimento facilmente.

### US-007 — Criar modelo — P0

Como usuário, quero montar um treino com foco, aquecimento, blocos e faixas para reutilizá-lo.

### US-008 — Duplicar modelo — P1

Como usuário, quero duplicar um treino para criar uma variação sem começar do zero.

### US-009 — Criar supersérie — P0

Como usuário, quero agrupar tríceps e bíceps em uma supersérie para que o app conduza o par corretamente.

### US-010 — Configurar exercício unilateral — P0

Como usuário, quero indicar execução por lado para registrar repetições iguais ou diferentes.

## Épico C — Início e continuidade da sessão

### US-011 — Iniciar pelo modelo — P0

Como usuário, quero iniciar uma sessão a partir da ficha escolhida.

### US-012 — Repetir sessão anterior — P1

Como usuário, quero repetir o último treino para reduzir navegação.

### US-013 — Criar treino livre — P1

Como usuário, quero iniciar sem modelo quando precisar improvisar.

### US-014 — Recuperar treino ativo — P0

Como usuário, quero voltar ao treino após bloquear ou fechar o app sem perder séries.

### US-015 — Alterar ordem durante sessão — P0

Como usuário, quero mudar a ordem quando um equipamento estiver ocupado sem alterar a ficha original.

### US-016 — Substituir exercício — P0

Como usuário, quero trocar um exercício e registrar o motivo.

## Épico D — Registro de séries

### US-017 — Registrar série comum — P0

Como usuário, quero ajustar carga e repetições por botões e concluir a série sem teclado.

### US-018 — Registrar aquecimento — P0

Como usuário, quero marcar séries de aquecimento para preservá-las sem inflar o volume efetivo.

### US-019 — Copiar série — P0

Como usuário, quero duplicar os valores da série anterior.

### US-020 — Reutilizar último desempenho — P0

Como usuário, quero preencher a primeira série com o último valor histórico do exercício.

### US-021 — Registrar RIR — P0

Como usuário, quero informar repetições em reserva para contextualizar a qualidade da série.

### US-022 — Registrar observação — P0

Como usuário, quero anotar amplitude, postura, desconforto ou particularidade da máquina.

### US-023 — Corrigir série — P0

Como usuário, quero editar uma série concluída quando perceber erro de registro.

### US-024 — Registrar lados separados — P0

Como usuário, quero informar repetições diferentes em cada lado quando necessário.

## Épico E — Técnicas e superséries

### US-025 — Marcar drop set — P0

Como usuário, quero marcar drop set na última série indicada e detalhar as reduções em observação.

### US-026 — Marcar rest-pause — P0

Como usuário, quero marcar rest-pause e registrar o total executado.

### US-027 — Receber alerta de técnica — P0

Como usuário, quero ser alertado quando ultrapassar a regra de uma técnica intensificadora por treino.

### US-028 — Executar rodada de supersérie — P0

Como usuário, quero concluir A e B sem descanso intermediário e descansar após o par.

### US-029 — Corrigir rodada de supersérie — P1

Como usuário, quero editar uma rodada preservando a ligação entre as duas séries.

## Épico F — Cronômetro

### US-030 — Iniciar descanso automático — P0

Como usuário, quero que o descanso sugerido comece ao concluir a série aplicável.

### US-031 — Ajustar descanso — P0

Como usuário, quero acrescentar ou retirar 15 segundos.

### US-032 — Pausar ou encerrar — P0

Como usuário, quero pausar, reiniciar ou encerrar o descanso.

### US-033 — Recuperar contador — P0

Como usuário, quero que o tempo restante seja recalculado ao retornar ao app.

### US-034 — Configurar alertas — P0

Como usuário, quero ativar ou desativar som e vibração.

## Épico G — Histórico e progressão

### US-035 — Ver resumo da sessão — P0

Como usuário, quero revisar duração, exercícios, séries e volume ao finalizar.

### US-036 — Consultar histórico por exercício — P0

Como usuário, quero ver cargas, repetições, RIR, técnicas e observações anteriores.

### US-037 — Comparar com última sessão — P0

Como usuário, quero ver o último resultado enquanto registro a sessão atual.

### US-038 — Ver candidato a progressão — P0

Como usuário, quero receber uma indicação quando atingir o topo da faixa em todas as séries com execução adequada.

### US-039 — Editar histórico — P1

Como usuário, quero corrigir uma sessão finalizada com rastreabilidade de edição.

### US-040 — Filtrar sessões — P1

Como usuário, quero filtrar por período, modelo e exercício.

## Épico H — Segurança dos dados

### US-041 — Exportar backup — P0

Como usuário, quero gerar um JSON versionado em local escolhido.

### US-042 — Restaurar backup — P0

Como usuário, quero validar e restaurar um backup sem corromper a base atual.

### US-043 — Exportar CSV — P0

Como usuário, quero analisar o histórico em planilha.

### US-044 — Redefinir dados — P1

Como usuário, quero apagar os dados locais somente após confirmação reforçada.

## Épico I — Pós-MVP

- **US-100:** registrar cardio por tempo, distância e intensidade — P2.
- **US-101:** registrar metas resumidas de macronutrientes e água — P2.
- **US-102:** integrar Health Connect — P2.
- **US-103:** registrar peso e medidas — P2.
- **US-104:** gerar gráficos de volume e frequência — P2.
- **US-105:** sincronizar backup opcional — P2.
