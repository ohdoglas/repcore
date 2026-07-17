# ADR-004 — Room como banco de dados local

- **Status:** Aceito
- **Data:** 2026-07-17

## Contexto

O domínio possui relações entre programas, semanas, modelos, blocos, exercícios, sessões e séries. Requer consultas de histórico, transações, índices, snapshots e migrações. Preferências simples possuem natureza diferente e ficarão no DataStore.

## Decisão

Usar Room estável como camada de persistência sobre SQLite para dados estruturados. No bootstrap, o Executor deve selecionar a linha estável compatível com o toolchain, preferencialmente Room 3.x estável, e fixar a versão no version catalog.

Usar Preferences DataStore para configurações do aplicativo.

## Alternativas consideradas

### SQLite direto

Oferece controle total, mas aumenta boilerplate e reduz verificação de consultas em compilação.

### JSON/arquivos

Inadequado para relações, concorrência, consultas e atualizações transacionais frequentes.

### Banco orientado a objetos de terceiros

Pode simplificar alguns modelos, mas adiciona dependência e não oferece vantagem necessária para este domínio.

## Consequências positivas

- SQL verificado em compilação.
- DAOs tipados.
- Transações explícitas.
- Migrações testáveis.
- Integração com Flow.

## Consequências negativas

- Schema deve ser planejado e migrado.
- Relações complexas exigem modelos agregados.
- Alterações após dados reais não podem usar migração destrutiva.

## Regras derivadas

- DAOs não são expostos à UI.
- Toda alteração de schema possui migração e teste.
- `fallbackToDestructiveMigration` é proibido para builds com dados reais.
- Entidades históricas preservam snapshots.
- Seed e restauração são transacionais.
- Versão Room e versão do backup são independentes.

## Referência

`https://developer.android.com/training/data-storage/room`
