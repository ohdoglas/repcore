# ADR-002 — Jetpack Compose para interface

- **Status:** Aceito
- **Data:** 2026-07-17

## Contexto

O app possui telas altamente orientadas a estado: sessão ativa, séries editáveis, cronômetro, superséries e histórico. A interface precisa ser rápida de iterar, testável e consistente com arquitetura unidirecional.

## Decisão

Construir toda a nova interface com Jetpack Compose e Material 3. Não criar layouts XML para features do MVP.

## Alternativas consideradas

### Views/XML

Tecnologia madura, mas exige mais sincronização manual entre estado e widgets e aumenta boilerplate para telas dinâmicas.

### Híbrido Compose + Views

Útil em migrações, mas o projeto é novo e não possui legado que justifique dois paradigmas.

## Consequências positivas

- UI declarativa orientada a estado.
- Componentização e previews.
- APIs oficiais de teste.
- Integração natural com ViewModel e Flow.
- Menor custo para estados dinâmicos do treino.

## Consequências negativas

- Requer disciplina para evitar recomposição e estado mal localizado.
- Algumas APIs podem evoluir rapidamente.
- Testes precisam usar semântica Compose corretamente.

## Regras derivadas

- Composables não acessam banco diretamente.
- Estado crítico fica fora de `remember` simples.
- Material 3 é baseline, com design system próprio mínimo.
- Componentes interativos devem possuir semântica e área de toque adequada.
