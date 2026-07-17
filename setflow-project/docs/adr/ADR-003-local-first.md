# ADR-003 — Arquitetura local-first sem backend no MVP

- **Status:** Aceito
- **Data:** 2026-07-17

## Contexto

O aplicativo atende inicialmente um único usuário, em um único aparelho, durante o treino. O valor principal não depende de rede. Login e sincronização aumentariam escopo, risco e tempo antes da primeira sessão útil.

## Decisão

Todos os dados do MVP terão fonte de verdade local. Não haverá autenticação, API remota, analytics remoto ou sincronização automática. Portabilidade será atendida por backup JSON e exportação CSV.

## Alternativas consideradas

### Firebase desde o início

Facilitaria sincronização futura, mas introduziria conta, rede, regras de segurança, conflitos e dependência operacional sem necessidade atual.

### Backend próprio

Oferece controle, porém possui maior custo técnico e operacional.

### Arquivos JSON como banco principal

Simples no início, mas inadequado para consultas, relações, transações e migrações do histórico.

## Consequências positivas

- Funciona offline.
- Menor superfície de privacidade.
- Menos permissões e dependências.
- Implementação focada no uso real.
- Dados sob controle do usuário.

## Consequências negativas

- Perda do aparelho exige backup prévio.
- Sem sincronização entre dispositivos.
- Colaboração e painel web ficam adiados.

## Regras derivadas

- Não declarar permissão INTERNET sem novo ADR.
- Toda operação principal funciona offline.
- Backup deve ser restaurável antes do release.
- Repositórios devem permitir fonte remota futura sem alterar UI diretamente, mas nenhuma abstração remota vazia deve ser criada agora.

## Critério de revisão

Revisar após MVP quando houver demanda concreta de segundo dispositivo ou backup automático.
