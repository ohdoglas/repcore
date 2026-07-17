# 04 — Fluxos de Usuário

## 1. Primeiro uso

```mermaid
flowchart TD
    A[Abrir app com base vazia] --> B[Apresentar plano inicial]
    B --> C{Importar agora?}
    C -->|Sim| D[Validar seed]
    D --> E[Inserir programa, modelos e exercícios em transação]
    E --> F[Definir Semana 1 como ativa]
    F --> G[Tela inicial]
    C -->|Não| H[Tela inicial vazia]
    H --> I[Criar modelo ou importar depois]
```

Regras:

- A importação deve ser transacional.
- Falha não pode deixar dados parciais.
- Importar novamente exige escolha entre cancelar, substituir programa ou criar cópia.

## 2. Iniciar treino previsto

```mermaid
flowchart TD
    A[Tela inicial] --> B[Card do treino do dia]
    B --> C[Prévia do modelo]
    C --> D{Sessão ativa existente?}
    D -->|Não| E[Criar sessão e snapshots]
    E --> F[Tela de treino ativo]
    D -->|Sim| G[Retomar ou cancelar sessão ativa]
    G -->|Retomar| F
```

A prévia mostra foco, aquecimento, exercícios, séries e duração aproximada de descanso, sem exigir confirmação de cada item.

## 3. Registrar série comum

1. Abrir o exercício atual.
2. App sugere carga e repetições da série anterior ou último histórico.
3. Ajustar com controles `−` e `+`.
4. Opcionalmente informar RIR, técnica e observação.
5. Tocar em **Concluir série**.
6. Persistir série.
7. Iniciar descanso, quando aplicável.
8. Preparar próxima série com valores copiados.

Falhas de persistência devem manter os valores na tela e apresentar ação de tentar novamente.

## 4. Série de aquecimento

```mermaid
flowchart LR
    A[Adicionar série] --> B[Selecionar Aquecimento]
    B --> C[Registrar carga e reps]
    C --> D[Concluir]
    D --> E[Persistir sem volume efetivo]
```

O app não deve consumir automaticamente uma das séries efetivas planejadas.

## 5. Exercício unilateral

1. O exercício abre com modo “mesmo valor nos dois lados”.
2. Usuário registra carga e repetições uma vez.
3. O app replica para esquerda e direita.
4. Usuário pode desativar o vínculo.
5. Campos de cada lado tornam-se independentes.
6. A conclusão exige pelo menos um valor válido para cada lado, salvo série marcada como interrompida.

## 6. Supersérie

```mermaid
flowchart TD
    A[Rodada 1: exercício A] --> B[Concluir série A]
    B --> C[Ir imediatamente ao exercício B]
    C --> D[Concluir série B]
    D --> E[Persistir vínculo da rodada]
    E --> F[Iniciar descanso do bloco]
    F --> G[Rodada 2]
```

- Não iniciar descanso entre A e B.
- Se B for pulado, solicitar motivo e permitir encerrar a rodada de forma incompleta.
- A contagem muscular permanece separada por exercício.

## 7. Técnica intensificadora

1. Usuário seleciona `Drop set` ou `Rest-pause`.
2. App verifica se já existe técnica intensificadora na sessão.
3. App verifica se é a última série prevista do exercício.
4. Se houver violação, mostrar aviso com explicação.
5. Usuário pode voltar ou confirmar exceção.
6. A série recebe técnica e flag de exceção quando aplicável.

## 8. Descanso

```mermaid
stateDiagram-v2
    [*] --> Idle
    Idle --> Running: série aplicável concluída
    Running --> Paused: pausar
    Paused --> Running: retomar
    Running --> Finished: tempo = 0
    Running --> Cancelled: encerrar
    Paused --> Cancelled: encerrar
    Finished --> Idle: dispensar
    Cancelled --> Idle
```

- O estado persiste `deadline`, duração original e ajustes.
- A UI calcula o restante a partir do relógio monotônico.
- Ao voltar do segundo plano, recalcula; não decrementa um contador persistido cegamente.

## 9. Equipamento indisponível

1. Abrir menu do exercício.
2. Escolher **Substituir nesta sessão**.
3. Pesquisar exercício existente ou criar temporário.
4. Informar motivo opcional.
5. Preservar posição, faixa e bloco quando compatíveis.
6. Registrar referência ao exercício planejado e ao executado.
7. Não alterar modelo sem ação separada.

## 10. Recuperar sessão

```mermaid
flowchart TD
    A[App aberto] --> B{Existe sessão ACTIVE?}
    B -->|Não| C[Início normal]
    B -->|Sim| D[Carregar sessão e séries]
    D --> E[Recalcular cronômetro]
    E --> F[Mostrar faixa Retomar treino]
    F --> G[Tela de treino ativo]
```

## 11. Finalizar sessão

1. Tocar em **Finalizar treino**.
2. App verifica exercícios incompletos e cronômetro ativo.
3. Mostrar resumo preliminar.
4. Usuário confirma.
5. Encerrar cronômetro.
6. Gravar `finishedAt` e status `COMPLETED` em transação.
7. Calcular resumo derivado.
8. Exibir progressões candidatas e observações pendentes.

## 12. Progressão

```mermaid
flowchart TD
    A[Sessão finalizada] --> B[Selecionar séries efetivas válidas]
    B --> C{Todas atingiram repMax?}
    C -->|Não| D[Sem sugestão]
    C -->|Sim| E{Execução adequada e sem alerta impeditivo?}
    E -->|Não| D
    E -->|Sim| F[Marcar candidato a aumento]
    F --> G[Mostrar sugestão na próxima sessão]
```

A sugestão nunca altera a carga automaticamente.

## 13. Backup e restauração

### Exportar

1. Abrir Configurações > Dados.
2. Selecionar **Exportar backup**.
3. Gerar payload em memória/arquivo temporário.
4. Abrir seletor de destino do Android.
5. Salvar JSON com data e versão.
6. Confirmar sucesso.

### Restaurar

1. Selecionar arquivo pelo seletor do Android.
2. Validar formato, versão, tamanho e referências.
3. Mostrar resumo do conteúdo.
4. Criar backup preventivo opcional da base atual.
5. Restaurar em transação.
6. Reabrir repositórios e validar contagens.
7. Em erro, manter base anterior intacta.
