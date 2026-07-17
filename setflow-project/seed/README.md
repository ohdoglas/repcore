# Seed do plano inicial

`initial-training-plan.json` é a representação estruturada do plano atual de Douglas.

## Regras

- O TXT atual é a fonte principal.
- O DOCX antigo fornece apenas aliases e contexto de variações.
- O parser deve validar `schemaVersion` e `seedVersion`.
- A importação deve ocorrer em transação.
- Uma segunda importação não pode duplicar silenciosamente o programa.
- Técnicas de finalização em braços aparecem como permitidas nos dois exercícios finais, mas a regra global permite uso em apenas uma das máquinas por sessão.
- Descanso de exercícios dentro de supersérie é zero; o descanso pertence ao bloco e ocorre após o par.

## Defaults de descanso

- 90–150 s → 120 s.
- 60–120 s → 90 s.
- 120–180 s → 150 s.
- 60–90 s → 75 s.
- valor fixo de 120 s → 120 s.

Esses defaults são editáveis e não substituem a faixa original.
