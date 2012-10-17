CREATE TABLE schuhladen.marken (
       ID INTEGER NOT NULL
     , marke CHAR(20)
     , typ CHAR(20)
     , CONSTRAINT PK_MARKEN PRIMARY KEY (ID)
);

CREATE TABLE schuhladen.schuhe (
       ID INTEGER NOT NULL
     , "größe" INTEGER
     , "preiß" DECIMAL
     , menge INTEGER
     , gender CHAR(0)
     , marken_id INTEGER
     , CONSTRAINT PK_SCHUHE PRIMARY KEY (ID)
     , CONSTRAINT FK_schuhe FOREIGN KEY (marken_id)
                  REFERENCES schuhladen.marken (ID)
);

