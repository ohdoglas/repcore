# 00 — Visão do Produto

## 1. Identificação

- **Produto:** SetFlow, nome provisório.
- **Tipo:** aplicativo Android pessoal para registro e condução de treino.
- **Usuário inicial:** Douglas.
- **Modelo operacional:** local-first, usuário único, uso offline.
- **Estado:** visão aprovada para orientar o MVP.

## 2. Contexto

Durante o treino, o usuário atualmente abre um bloco de notas e digita exercício, carga, séries, repetições, técnicas e observações. O processo funciona, mas exige digitação, dificulta consultar o último desempenho, separa o cronômetro do registro e produz histórico pouco estruturado.

O plano atual possui um ciclo de duas semanas, cinco sessões por semana, grupos musculares isolados, faixas de repetições e descanso, exercícios unilaterais, superséries, séries de aquecimento, RIR e técnicas opcionais. O plano antigo mostra que exercícios, equipamentos e técnicas mudam com o tempo. Portanto, o produto deve registrar a execução real sem tornar a ficha rígida.

## 3. Problema

O usuário precisa controlar progressão e descanso durante o treino, mas o registro manual:

- exige muitos toques e digitação;
- interrompe o ritmo entre séries;
- dificulta comparar a sessão atual com a anterior;
- não aplica automaticamente o descanso adequado;
- não diferencia aquecimento de séries efetivas;
- não representa bem superséries e exercícios por lado;
- dificulta transformar anotações em histórico pesquisável.

## 4. Visão

> Ser a tela operacional do treino: mostrar o que fazer agora, permitir registrar o que ocorreu em poucos toques e preservar contexto suficiente para decidir a próxima carga com segurança e consistência.

## 5. Proposta de valor

SetFlow concentra em uma única tela:

- plano do dia;
- último desempenho do exercício;
- entrada rápida de carga e repetições;
- indicação de RIR e técnica;
- cronômetro contextual de descanso;
- observações de execução ou desconforto;
- resumo e histórico da sessão.

## 6. Jobs to be Done

### JTBD-01 — Iniciar sem preparar anotações

Quando eu chegar à academia, quero abrir o treino previsto para a semana atual para começar sem copiar a ficha para outro lugar.

### JTBD-02 — Registrar sem perder foco

Quando eu terminar uma série, quero registrar carga e repetições em poucos toques para não quebrar o ritmo do treino.

### JTBD-03 — Respeitar o descanso

Quando eu concluir uma série ou supersérie, quero que o descanso correto comece imediatamente para manter a sessão consistente.

### JTBD-04 — Decidir progressão

Quando eu executar novamente um exercício, quero ver o último resultado e a faixa planejada para decidir se mantenho ou aumento a carga.

### JTBD-05 — Preservar o treino real

Quando eu trocar equipamento, alterar ordem, reduzir volume ou aplicar uma técnica, quero registrar o que realmente aconteceu sem destruir o modelo original.

## 7. Princípios do produto

1. **Treinar mais, digitar menos.** A ação mais frequente deve exigir um toque ou ajuste curto.
2. **Execução real acima do plano ideal.** O modelo orienta; a sessão registra a realidade.
3. **Histórico no ponto de decisão.** O último desempenho aparece junto à série atual.
4. **Descanso contextual.** O cronômetro conhece exercício, bloco e supersérie.
5. **Flexibilidade controlada.** Permitir substituições e exceções, mas emitir alertas quando regras do plano forem contrariadas.
6. **Dados locais e privados.** Nenhum login ou envio automático no MVP.
7. **Recuperação de estado.** Fechar, bloquear ou recriar a tela não pode apagar o treino.
8. **Sem prescrição clínica.** O app registra e calcula; não diagnostica nem substitui orientação profissional.

## 8. Objetivos do MVP

- Cadastrar e editar exercícios.
- Disponibilizar o plano de duas semanas como carga inicial.
- Criar e editar modelos de treino.
- Iniciar, pausar, recuperar e finalizar uma sessão.
- Registrar aquecimento e séries efetivas.
- Registrar carga, repetições, lado, RIR, técnica e observação.
- Representar superséries e iniciar descanso após o par.
- Exibir histórico recente por exercício.
- Calcular volume efetivo e sinalizar possível progressão.
- Exportar e restaurar os dados localmente.

## 9. Não objetivos do MVP

- Gerar treino automaticamente.
- Prescrever carga, dieta ou suplementação.
- Criar rede social, ranking ou comunidade.
- Sincronizar entre dispositivos.
- Integrar smartwatch, Health Connect ou sensores.
- Manter banco nutricional.
- Publicar em iOS.
- Suportar múltiplos usuários.

## 10. Critérios de sucesso

O MVP é considerado útil quando:

- uma série comum pode ser registrada sem teclado;
- a próxima série reaproveita os valores anteriores;
- o último desempenho fica visível durante a execução;
- o descanso inicia no momento correto;
- um treino interrompido pode ser recuperado;
- o ciclo semanal correto pode ser aberto em até três ações;
- o histórico responde “quanto usei, quantas repetições fiz e como executei?”;
- o usuário deixa de depender do bloco de notas durante a sessão.

## 11. Vocabulário de domínio

- **Programa:** ciclo completo de treino, por exemplo Semanas 1 e 2.
- **Semana do programa:** posição no ciclo, não necessariamente semana civil.
- **Modelo de treino:** ficha reutilizável de uma sessão.
- **Sessão:** execução real de um modelo ou treino livre.
- **Bloco:** agrupamento de um ou mais exercícios; pode ser normal ou supersérie.
- **Série de aquecimento:** prepara o movimento e não conta como volume efetivo.
- **Série efetiva:** entra no volume e na análise de progressão.
- **RIR:** repetições estimadas em reserva.
- **Técnica intensificadora:** drop set, rest-pause ou outra técnica aplicada à série.
- **Progressão dupla:** primeiro aumentar repetições dentro da faixa; depois aumentar carga.

## 12. Premissas

- O usuário treina prioritariamente com o celular em mãos ou próximo ao equipamento.
- A unidade inicial de carga é quilograma.
- O aplicativo será instalado diretamente no aparelho pessoal antes de qualquer publicação pública.
- O plano inicial poderá ser editado sem alterar sessões históricas.
- O nome SetFlow e o package final ainda podem ser alterados por ADR específico antes da primeira versão assinada.
