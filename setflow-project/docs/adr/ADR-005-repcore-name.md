# ADR-005 — Repcore como nome técnico inicial

- **Status:** Aceito
- **Data:** 2026-07-17

## Contexto

A documentação inicial usa SetFlow como nome provisório e indica que o nome final ainda pode mudar antes da primeira versão assinada. Durante o início do projeto, o proprietário manifestou preferência por Repcore.

## Decisão

Usar **Repcore** como nome técnico inicial do aplicativo, app label e package base `com.douglas.repcore`.

## Consequências positivas

- Evita renomear package e applicationId após a instalação inicial em aparelho real.
- Alinha o bootstrap ao nome preferido antes de dados reais e releases assinadas.
- Mantém SetFlow apenas como histórico documental até uma migração textual completa.

## Consequências negativas

- A documentação fundacional ainda contém referências a SetFlow.
- Uma entrega posterior deve consolidar nomes, títulos e manifestos documentais para reduzir ambiguidade.

## Regras derivadas

- Código novo deve usar Repcore quando se referir ao app.
- Requisitos e regras existentes continuam válidos mesmo quando mencionarem SetFlow.
- A migração textual completa da documentação deve ser feita em entrega própria.
