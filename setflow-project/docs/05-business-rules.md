# 05 — Regras de Negócio

## 1. Programa e ciclo

- **BR-001:** o programa inicial possui ciclo de duas semanas.
- **BR-002:** Semana 1 e Semana 2 são posições do programa; não devem ser inferidas exclusivamente pela semana civil.
- **BR-003:** a semana ativa muda apenas por ação explícita ou por configuração futura aprovada.
- **BR-004:** sábado e domingo não possuem treino previsto no seed, mas o usuário pode iniciar treino livre.
- **BR-005:** editar um modelo afeta somente sessões futuras.
- **BR-006:** iniciar sessão cria snapshots das informações necessárias para preservar o histórico.

## 2. Sessão

- **BR-010:** somente uma sessão pode ter status `ACTIVE`.
- **BR-011:** iniciar nova sessão com outra ativa exige retomar, finalizar ou cancelar a existente.
- **BR-012:** sessão cancelada permanece no banco apenas quando contiver registros; caso contrário pode ser removida.
- **BR-013:** reordenação ou substituição na sessão não altera o modelo.
- **BR-014:** sessão finalizada pode ser editada, registrando `updatedAt` e flag de edição.
- **BR-015:** duração da sessão é calculada entre início e fim, descontando pausa somente se uma função explícita de pausa da sessão for implementada.

## 3. Séries

- **BR-020:** série pode ser `WARMUP` ou `EFFECTIVE` no MVP.
- **BR-021:** aquecimento não conta em séries efetivas, volume, progressão ou recordes.
- **BR-022:** série efetiva válida exige conclusão e pelo menos uma medida compatível com o exercício.
- **BR-023:** carga e repetições não podem ser negativas.
- **BR-024:** zero quilograma é válido para peso corporal, elástico ou máquina sem valor conhecido.
- **BR-025:** repetições zero somente são válidas em série interrompida ou exercício medido por tempo/distância no futuro.
- **BR-026:** uma série copiada recebe novo identificador e novo horário; nunca reutiliza a mesma entidade.
- **BR-027:** excluir série recalcula numeração exibida, mas não precisa reutilizar identificadores.
- **BR-028:** a ordem de séries é explícita e não deve depender de data de criação.

## 4. Lateralidade

- **BR-030:** exercícios podem ser `BILATERAL`, `PER_SIDE` ou `ALTERNATING`.
- **BR-031:** em `PER_SIDE`, o padrão é espelhar carga e repetições, permitindo desvincular.
- **BR-032:** volume de exercício por lado deve aplicar a regra configurada no exercício; por padrão, somar os dois lados quando registrados separadamente.
- **BR-033:** o histórico deve mostrar claramente se o valor é por lado.

## 5. Superséries

- **BR-040:** uma supersérie contém dois ou mais exercícios no mesmo bloco e uma quantidade de rodadas.
- **BR-041:** não há descanso automático entre exercícios da mesma rodada.
- **BR-042:** o descanso inicia após o último exercício concluído da rodada.
- **BR-043:** cada exercício mantém sua própria contagem de séries e volume.
- **BR-044:** séries da mesma rodada compartilham `roundIndex` e `blockInstanceId`.
- **BR-045:** rodada incompleta exige motivo ou confirmação antes de avançar.
- **BR-046:** no seed de braços, o descanso padrão após o par é 120 segundos, dentro da faixa de 90 a 150.

## 6. Técnicas intensificadoras

- **BR-050:** `DROP_SET` e `REST_PAUSE` são técnicas intensificadoras no MVP.
- **BR-051:** o plano recomenda no máximo uma técnica intensificadora por sessão.
- **BR-052:** a técnica deve ser aplicada somente na última série indicada pelo modelo.
- **BR-053:** violação de BR-051 ou BR-052 gera aviso, não bloqueio absoluto.
- **BR-054:** confirmação de exceção deve ser persistida para distinguir execução intencional de erro.
- **BR-055:** `SUPERSET` pertence ao bloco, não é contada como técnica intensificadora individual para a regra de limite.
- **BR-056:** detalhes internos de drop set ou rest-pause podem ficar em observação no MVP.

## 7. RIR e execução

- **BR-060:** o alvo geral do plano é aproximadamente 1 a 2 RIR na maioria das séries.
- **BR-061:** última série de isolador pode ficar próxima da falha.
- **BR-062:** RIR é opcional por série, mas recomendado.
- **BR-063:** série marcada com dor articular persistente, amplitude comprometida ou execução instável não deve gerar sugestão automática de progressão.
- **BR-064:** o aplicativo registra percepção; não valida tecnicamente a execução.

## 8. Descanso

- **BR-070:** cada exercício ou bloco pode possuir `restMinSeconds`, `restMaxSeconds` e `defaultRestSeconds`.
- **BR-071:** compostos pesados do seed usam faixa de 120 a 180 segundos.
- **BR-072:** máquinas e compostos moderados usam 90 a 150 segundos.
- **BR-073:** isoladores usam 60 a 120 segundos, com exceções específicas.
- **BR-074:** superséries de braços usam 90 a 150 segundos após o par.
- **BR-075:** concluir série inicia o valor padrão, não o mínimo ou máximo automaticamente.
- **BR-076:** ajustes manuais não alteram o modelo, salvo ação explícita “salvar como padrão”.
- **BR-077:** o restante deve ser calculado a partir de deadline, não de decrementos persistidos.
- **BR-078:** ao expirar, o estado muda para `FINISHED` uma única vez e dispara feedback permitido.
- **BR-079:** finalizar ou cancelar sessão encerra o cronômetro associado.

## 9. Progressão

- **BR-080:** o método padrão é progressão dupla.
- **BR-081:** candidato a aumento exige que todas as séries efetivas planejadas atinjam `repMax`.
- **BR-082:** séries extras não são obrigatórias para cumprir BR-081, mas entram no histórico.
- **BR-083:** aquecimento e séries inválidas são ignorados.
- **BR-084:** deve existir indicação de execução adequada; no MVP, ausência de flags impeditivas e RIR compatível quando informado.
- **BR-085:** a sugestão apresenta último valor e incremento configurado.
- **BR-086:** o usuário decide aplicar, ignorar ou adiar a sugestão.
- **BR-087:** a carga nunca é alterada retroativamente.
- **BR-088:** progressão pode ocorrer por repetições mesmo antes de aumento de carga.

## 10. Cálculos

- **BR-090:** volume bilateral padrão = `loadKg × reps`.
- **BR-091:** volume por lado separado = soma de `loadKg × reps` de cada lado.
- **BR-092:** séries de peso corporal sem carga externa não geram tonelagem precisa; podem mostrar repetições e volume externo separadamente.
- **BR-093:** recordes devem indicar a métrica: maior carga, maior repetição na carga ou maior volume de série.
- **BR-094:** cálculos derivados não devem ser persistidos quando puderem ser recalculados com segurança, salvo cache justificável.

## 11. Histórico e integridade

- **BR-100:** exercício usado por sessão não pode ser removido fisicamente pela UI.
- **BR-101:** nomes e configurações relevantes são preservados por snapshot.
- **BR-102:** horário de treino usa tempo civil; duração e cronômetros usam fonte monotônica durante execução.
- **BR-103:** alterações históricas devem atualizar resumos derivados.
- **BR-104:** banco não pode conter série sem exercício de sessão válido.
- **BR-105:** operações compostas de finalizar sessão, importar seed e restaurar backup são transacionais.

## 12. Seed e legado

- **BR-110:** o plano TXT atual é a referência principal da carga inicial.
- **BR-111:** o documento antigo serve como fonte de aliases, variações e evidência de que modelos mudam.
- **BR-112:** divergências entre antigo e novo não devem ser mescladas silenciosamente; o seed segue o plano novo.
- **BR-113:** o seed possui `schemaVersion` e `seedVersion`.
- **BR-114:** uma nova versão do seed não substitui personalizações sem confirmação.

## 13. Backup

- **BR-120:** exportação inclui schema, versão, data e todos os dados necessários para restauração.
- **BR-121:** preferências sensíveis ao dispositivo podem ser restauradas seletivamente.
- **BR-122:** importação inválida não altera a base atual.
- **BR-123:** restauração completa ocorre em transação ou estratégia equivalente com rollback.
- **BR-124:** CSV é exportação analítica e não formato de restauração.
