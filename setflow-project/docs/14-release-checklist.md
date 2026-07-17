# 14 — Checklist de Release

## 1. Identificação

- [ ] Versão definida em SemVer.
- [ ] `versionCode` incrementado.
- [ ] Nome SetFlow/package confirmados para esta release.
- [ ] Changelog interno atualizado.
- [ ] Commit/tag da release identificado.

## 2. Escopo

- [ ] Todos os itens da release estão `DONE`.
- [ ] Nenhum P0 aberto.
- [ ] P1/P2 adiados estão registrados.
- [ ] Documentação corresponde ao comportamento entregue.

## 3. Build

- [ ] Dependências usam versões fixas e estáveis.
- [ ] `compileSdk` e `targetSdk` confirmados.
- [ ] Build release concluído.
- [ ] Assinatura configurada fora do repositório.
- [ ] Segredos não foram versionados.
- [ ] Minificação testada, quando habilitada.
- [ ] APK/AAB instalado e aberto.

## 4. Qualidade

- [ ] `./gradlew lint` verde.
- [ ] `./gradlew test` verde.
- [ ] `./gradlew connectedCheck` verde ou impedimento documentado.
- [ ] Smoke test completo em API 26 e API 36.
- [ ] Teste no aparelho principal concluído.
- [ ] Sem crash no fluxo principal.

## 5. Dados e migração

- [ ] Migração a partir da última versão instalada testada.
- [ ] Dados históricos preservados.
- [ ] Sessão ativa anterior tratada corretamente.
- [ ] Seed não foi reimportado indevidamente.
- [ ] Backup da versão anterior exportado.
- [ ] Backup restaurado na nova versão.
- [ ] Arquivo incompatível apresenta erro sem alterar base.

## 6. Fluxos funcionais

- [ ] Selecionar semana ativa.
- [ ] Abrir treino do dia.
- [ ] Iniciar sessão.
- [ ] Registrar aquecimento.
- [ ] Registrar série efetiva.
- [ ] Copiar série anterior.
- [ ] Registrar RIR e observação.
- [ ] Registrar exercício unilateral.
- [ ] Executar supersérie completa.
- [ ] Aplicar técnica e validar alerta.
- [ ] Ajustar cronômetro.
- [ ] Bloquear e desbloquear aparelho.
- [ ] Encerrar processo e recuperar sessão.
- [ ] Finalizar treino.
- [ ] Abrir histórico e último desempenho.
- [ ] Exportar JSON e CSV.

## 7. UI e acessibilidade

- [ ] Tema claro e escuro.
- [ ] Fonte padrão e aumentada.
- [ ] Orientação suportada conforme decisão do projeto.
- [ ] TalkBack nos fluxos de iniciar, concluir série e timer.
- [ ] Contraste e áreas de toque revisados.
- [ ] Sem textos truncados críticos.
- [ ] Ações destrutivas possuem confirmação.

## 8. Permissões e privacidade

- [ ] Manifest contém apenas permissões necessárias.
- [ ] Nenhuma permissão de alarme exato no MVP.
- [ ] Nenhuma INTERNET permission sem ADR.
- [ ] Logs release não exibem dados de treino.
- [ ] Tela Sobre informa que os dados são locais.
- [ ] Exportação acontece somente por ação explícita.

## 9. Cronômetro

- [ ] Contagem em primeiro plano correta.
- [ ] Pausa/retomada correta.
- [ ] ±15 segundos correto.
- [ ] Retorno após bloqueio recalcula.
- [ ] Processo recriado recupera estado.
- [ ] Final da sessão encerra timer.
- [ ] Som/vibração respeitam configurações.

## 10. Distribuição pessoal

- [ ] APK copiada para local seguro.
- [ ] Hash do artefato registrado opcionalmente.
- [ ] Chave de assinatura armazenada com backup seguro.
- [ ] Instrução de instalação registrada.
- [ ] Backup atual criado antes de atualizar no aparelho principal.

## 11. Rollback

- [ ] APK da versão anterior preservada.
- [ ] Backup compatível disponível.
- [ ] Limitações de downgrade conhecidas.
- [ ] Procedimento de restauração testado.

## 12. Aprovação

```text
Versão:
Data:
Commit/tag:
Orquestrador:
Executor:
Resultado dos testes:
Riscos aceitos:
Artefato:
Status: APPROVED | REJECTED
```
