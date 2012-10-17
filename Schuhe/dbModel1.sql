CREATE TABLE schuhladen.marken (
       ID INTEGER NOT NULL generated always as identity
     , marke CHAR(20)
     , typ CHAR(20)
     , CONSTRAINT PK_MARKEN PRIMARY KEY (ID)
);

CREATE TABLE schuhladen.schuhe (
       ID INTEGER NOT NULL
     , "größe" INTEGER
     , "preis" DECIMAL
     , menge INTEGER
     , gender CHARACTER
     , marken_id INTEGER
     , CONSTRAINT PK_SCHUHE PRIMARY KEY (ID)
     , CONSTRAINT FK_schuhe FOREIGN KEY (marken_id)
                  REFERENCES schuhladen.marken (ID)
);

drop table schuhladen.marken;
drop table schuhladen.schuhe;