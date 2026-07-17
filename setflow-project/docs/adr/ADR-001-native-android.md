# ADR-001 — Android nativo

- **Status:** Aceito
- **Data:** 2026-07-17

## Contexto

O produto é pessoal, será usado inicialmente em um aparelho Android e precisa de boa integração com ciclo de vida, armazenamento local, vibração, áudio, bloqueio de tela e componentes modernos da plataforma. Não há requisito de iOS ou web no MVP.

## Decisão

Desenvolver o MVP como aplicativo Android nativo em Kotlin, usando Android Studio e APIs AndroidX.

## Alternativas consideradas

### Flutter

Vantagens: possibilidade de multiplataforma e UI consistente. Desvantagens: camada adicional, toolchain distinta e benefício multiplataforma sem demanda atual.

### React Native

Vantagens: familiaridade com JavaScript/TypeScript. Desvantagens: ponte/runtime adicional e maior complexidade para um produto exclusivamente Android.

### PWA

Vantagens: implantação simples. Desvantagens: integração e confiabilidade inferiores para persistência, feedback e uso de tela bloqueada no cenário principal.

## Consequências positivas

- Acesso direto ao ecossistema Android.
- Menor ambiguidade para ciclo de vida e armazenamento.
- Melhor alinhamento com Android Studio e Codex no projeto.
- Caminho claro para Compose, Room e DataStore.

## Consequências negativas

- Sem versão iOS no mesmo código.
- Exige conhecimento de Kotlin e Android.
- Migração futura para multiplataforma teria custo.

## Critério de revisão

Reavaliar somente quando existir requisito real de outra plataforma e o MVP Android estiver estável.
