# 08 — Especificação UI/UX

## 1. Objetivo de experiência

A interface deve funcionar durante esforço físico, com atenção dividida, mãos potencialmente ocupadas e necessidade de retorno rápido ao exercício. O app não deve parecer um formulário administrativo.

## 2. Princípios

- Ação principal sempre evidente.
- Pouca digitação.
- Controles grandes e distantes de ações destrutivas.
- Informação histórica no contexto.
- Estado persistente e explícito.
- Correção rápida.
- Contraste adequado em academia iluminada ou escura.
- Uso confortável com uma mão.

## 3. Navegação principal

Barra inferior fora do treino ativo:

1. Início.
2. Treinos.
3. Histórico.
4. Configurações.

Durante treino ativo, usar fluxo dedicado em tela cheia. Navegação acidental para fora deve preservar o estado e oferecer retorno visível.

## 4. Tela Início

### Conteúdo

- Faixa de sessão ativa, quando existir.
- Semana ativa do programa.
- Card “Treino de hoje”.
- Botão primário **Iniciar treino**.
- Ações secundárias: repetir último, escolher outro, treino livre.
- Resumo da última sessão.

### Estados

- Base vazia.
- Seed disponível.
- Programa ativo.
- Sessão ativa.
- Dia sem treino previsto.

## 5. Tela Programa/Treinos

- Alternador Semana 1 / Semana 2.
- Lista dos dias.
- Nome, foco, quantidade de exercícios e séries.
- Ações editar, duplicar, arquivar e iniciar.
- Reordenação por arraste em modo de edição.

## 6. Tela de treino ativo

### Cabeçalho

- Nome do treino.
- Duração da sessão.
- Progresso: exercícios e séries.
- Menu de sessão.

### Cronômetro persistente

Quando ativo:

```text
Descanso 01:32
Faixa 01:30–02:30 · Supersérie 2
[-15s] [Pausar] [+15s]
```

Pode aparecer como faixa fixada no topo ou painel inferior, sem esconder série atual.

### Card de exercício

- Nome e equipamento.
- Faixa planejada.
- Indicação “por lado” quando aplicável.
- Último treino resumido.
- Séries em linhas compactas.
- Ações adicionar aquecimento, adicionar efetiva, substituir e observar.

### Linha de série

Formato sugerido:

```text
1  70,0 kg  10 reps  RIR 2  Normal  ✓
```

Interações:

- tocar na carga abre stepper/painel numérico;
- tocar em reps abre stepper;
- toque longo não deve ser requisito essencial;
- marcar conclusão persiste e inicia descanso;
- deslizar para excluir é opcional e sempre oferece desfazer.

### Entrada rápida

- Stepper de carga usa incremento do exercício.
- Stepper de repetições usa 1.
- Botão “copiar anterior”.
- Botão “usar último treino”.
- Teclado numérico somente quando usuário toca no valor diretamente.

## 7. Supersérie

O bloco deve ser visualmente agrupado:

```text
SUPER-SÉRIE 1 · Rodada 2 de 3
A · Tríceps na barra W       concluído
B · Rosca direta barra W     atual
Descanso após B: 02:00
```

Ao concluir A, rolar/focar B. Ao concluir B, abrir cronômetro e marcar rodada completa.

## 8. Técnicas

Seletor em chips:

- Normal.
- Drop set.
- Rest-pause.

Ao escolher técnica fora da regra, usar diálogo curto:

> O plano indica esta técnica apenas na última série e recomenda uma técnica intensificadora por treino. Registrar mesmo assim?

Ações: **Voltar** e **Registrar exceção**.

## 9. RIR e observações

RIR em seletor rápido: `0`, `0,5`, `1`, `1,5`, `2`, `3+`, `Não informar`.

Observação abre bottom sheet com:

- campo livre;
- chips: amplitude reduzida, execução instável, desconforto, equipamento ocupado, carga estimada;
- texto anterior do mesmo exercício opcionalmente visível.

## 10. Exercícios unilaterais

Padrão compacto:

```text
Carga: 20 kg      Reps: 10
[✓] Mesmo nos dois lados
```

Ao desvincular:

```text
Esquerda: 20 kg × 10
Direita: 20 kg × 9
```

## 11. Finalização

Resumo:

- duração;
- exercícios concluídos/pulados;
- séries efetivas e aquecimento;
- volume calculável;
- técnicas usadas;
- candidatos a progressão;
- observações com alerta.

Se houver itens incompletos, mostrar lista antes da confirmação.

## 12. Histórico

### Lista

- Data e horário.
- Nome do treino.
- Duração.
- Séries efetivas.
- Status.

### Detalhe

- Resumo.
- Blocos na ordem executada.
- Séries e observações.
- Indicação de edição posterior.
- Ação corrigir.

### Histórico do exercício

- Últimas sessões em lista; gráfico é pós-MVP.
- Destaque para maior carga e última execução.
- Filtros simples por período.

## 13. Configurações

Seções:

- Treino: incremento, descanso, auto-início, manter tela ligada.
- Feedback: som e vibração.
- Aparência: tema.
- Dados: seed, backup, restauração, CSV e redefinição.
- Sobre: versão e limitações.

## 14. Estados de interface

Toda tela de dados deve prever:

- carregando;
- conteúdo;
- vazio;
- erro recuperável;
- erro impeditivo;
- operação em andamento.

Não usar spinner que bloqueie a tela para ajustes simples de série; aplicar estado otimista somente quando houver estratégia segura de rollback.

## 15. Acessibilidade

- Área mínima recomendada de toque de 48 dp.
- Rótulos de conteúdo para ícones.
- Não depender apenas de cor.
- Suportar escala de fonte sem cortar ação principal.
- Ordem de foco coerente.
- Cronômetro deve anunciar conclusão sem leitura excessiva a cada segundo.
- Testar TalkBack nos fluxos críticos.

## 16. Tema e identidade

O MVP deve usar Material 3 com identidade sóbria. Evitar estética excessivamente agressiva ou cheia de elementos decorativos. O conteúdo deve dominar a tela.

Tokens de design devem ficar no design system, não espalhados por features. Nome e paleta final serão definidos posteriormente.

## 17. Microcopy principal

- “Concluir série”.
- “Adicionar aquecimento”.
- “Copiar série anterior”.
- “Usar último desempenho”.
- “Descanso concluído”.
- “Registrar exceção”.
- “Substituir somente nesta sessão”.
- “Retomar treino”.
- “Finalizar treino”.
- “Dados salvos neste aparelho”.
