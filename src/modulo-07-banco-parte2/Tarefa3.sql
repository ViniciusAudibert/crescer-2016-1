CREATE OR REPLACE PACKAGE pck_concurso
AS
  FUNCTION ultimoConcursoId
    RETURN NUMBER;
  FUNCTION valorProximoConcurso
    RETURN NUMBER;
  FUNCTION geraProximaData
    RETURN DATE;
  FUNCTION obtemAcertos(
      pConcursoId NUMBER)
    RETURN NUMBER;
  PROCEDURE geraProximoConcurso;
END;
CREATE OR REPLACE PACKAGE BODY pck_concurso
AS
  FUNCTION ultimoConcursoId
    RETURN NUMBER
  AS
    vId NUMBER;
  BEGIN
    SELECT MAX(IDCONCURSO) INTO vId FROM CONCURSO;
    RETURN vId;
  END;
  FUNCTION valorProximoConcurso
    RETURN NUMBER
  AS
    vValorTotal     NUMBER;
    vId             NUMBER;
    vAcumulou       NUMBER;
    vValorAcumulado NUMBER;
  BEGIN
    vId             := ULTIMOCONCURSOID;
    vValorAcumulado := 0;
    vAcumulou       := 0;
    vValorTotal     := 0;
    SELECT SUM(VALOR) INTO vValorTotal FROM APOSTA WHERE IDCONCURSO = vId;
    SELECT ACUMULOU INTO vAcumulou FROM CONCURSO WHERE IDCONCURSO = vId;
    IF(vAcumulou > 0) THEN
      SELECT PREMIO_SENA + PREMIO_QUINA + PREMIO_QUADRA + ACUMULADO_PROXIMO_05 + ACUMULADO_FINAL_ANO
      INTO vValorAcumulado
      FROM CONCURSO
      WHERE IDCONCURSO = vId;
      vValorTotal     := (vValorTotal * 0.453) + vValorAcumulado;
    END IF;
    RETURN vValorTotal;
  END;
  FUNCTION geraProximaData
    RETURN DATE
  AS
    vDiaSemana   NUMBER;
    vProximaData DATE;
    vId          NUMBER;
  BEGIN
    vId := ultimoConcursoId;
    SELECT TO_CHAR(DATA_SORTEIO,'D')
    INTO vDiaSemana
    FROM CONCURSO
    WHERE IDCONCURSO = vId;
    IF(vDiaSemana    = 4) THEN
      SELECT (DATA_SORTEIO + 3)
      INTO vProximaData
      FROM CONCURSO
      WHERE IDCONCURSO = vId;
    ELSE
      SELECT (DATA_SORTEIO + 4)
      INTO vProximaData
      FROM CONCURSO
      WHERE IDCONCURSO = vId;
    END IF;
    RETURN vProximaData;
  END;
  FUNCTION obtemAcertos(
      pConcursoId NUMBER)
    RETURN NUMBER
  AS
    vCol1              NUMBER;
    vCol2              NUMBER;
    vCol3              NUMBER;
    vCol4              NUMBER;
    vCol5              NUMBER;
    vCol6              NUMBER;
    vAcertos           NUMBER;
    vQuantidadeAcertos NUMBER;
    CURSOR C_NUMEROS
    IS
      SELECT N1,N2,N3,N4,N5,N6 FROM ARQUIVO_APOSTA_A WHERE CONCURSO = pConcursoId;
  BEGIN
    vQuantidadeAcertos := 0;
    SELECT PRIMEIRA_DEZENA
    INTO vCol1
    FROM CONCURSO
    WHERE IDCONCURSO = pConcursoId;
    SELECT SEGUNDA_DEZENA INTO vCol2 FROM CONCURSO WHERE IDCONCURSO = pConcursoId;
    SELECT TERCEIRA_DEZENA
    INTO vCol3
    FROM CONCURSO
    WHERE IDCONCURSO = pConcursoId;
    SELECT QUARTA_DEZENA INTO vCol4 FROM CONCURSO WHERE IDCONCURSO = pConcursoId;
    SELECT QUINTA_DEZENA INTO vCol5 FROM CONCURSO WHERE IDCONCURSO = pConcursoId;
    SELECT SEXTA_DEZENA INTO vCol6 FROM CONCURSO WHERE IDCONCURSO = pConcursoId;
    FOR numero IN C_NUMEROS
    LOOP
      SELECT COUNT(1)
      INTO vAcertos
      FROM CONCURSO
      WHERE numero.N1      IN (vCol1, vCol2, vCol3, vCol4, vCol5, vCol6)
      AND numero.N2        IN (vCol1, vCol2, vCol3, vCol4, vCol5, vCol6)
      AND numero.N3        IN (vCol1, vCol2, vCol3, vCol4, vCol5, vCol6)
      AND numero.N4        IN (vCol1, vCol2, vCol3, vCol4, vCol5, vCol6)
      AND numero.N5        IN (vCol1, vCol2, vCol3, vCol4, vCol5, vCol6)
      AND numero.N6        IN (vCol1, vCol2, vCol3, vCol4, vCol5, vCol6);
      IF(vAcertos           > 0) THEN
        vQuantidadeAcertos := vQuantidadeAcertos + 1;
      END IF;
    END LOOP;
    RETURN vQuantidadeAcertos;
  END;
  PROCEDURE geraProximoConcurso
  AS
    vId         NUMBER;
    vValorTotal NUMBER;
    vData CONCURSO.DATA_SORTEIO%TYPE;
  BEGIN
    vId         := ULTIMOCONCURSOID + 1;
    vValorTotal := VALORPROXIMOCONCURSO;
    vData       := GERAPROXIMADATA;
    INSERT
    INTO CONCURSO
      (
        IDCONCURSO,
        DATA_SORTEIO,
        PREMIO_SENA,
        PREMIO_QUINA,
        PREMIO_QUADRA,
        ACUMULADO_PROXIMO_05,
        ACUMULADO_FINAL_ANO,
        ACUMULOU
      )
      VALUES
      (
        vId,
        vData,
        vValorTotal * 0.35,
        vValorTotal * 0.19,
        vValorTotal * 0.19,
        vValorTotal * 0.22,
        vValorTotal * 0.05,
        0
      );
    COMMIT;
  END;
  PROCEDURE atualizaAcertadores
    (
      vIDConcurso NUMBER
    )
  AS
    vAcumulou NUMBER;
  BEGIN
    vAcumulou   := obtemAcertos(vIDConcurso);
    IF(vAcumulou > 0) THEN
      UPDATE CONCURSO SET ACUMULOU = 1 WHERE IDCONCURSO = vIDConcurso;
    ELSE
      UPDATE CONCURSO SET ACUMULOU = 0 WHERE IDCONCURSO = vIDConcurso;
    END IF;
  END;
END pck_concurso;