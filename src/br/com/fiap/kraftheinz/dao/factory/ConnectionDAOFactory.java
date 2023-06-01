package br.com.fiap.kraftheinz.dao.factory;

import br.com.fiap.kraftheinz.dao.*;

public class ConnectionDAOFactory extends DAOFactory {


        @Override
        public EmbalagemDao getEmbalagemDao() {
            return new EmbalagemDao();
        }

        @Override
        public FabricaDao getFabricaDao() {
            return new FabricaDao();
        }

        @Override
        public LoteDao getLoteDao() {
            return new LoteDao();
        }
        @Override
        public MarcaDao getMarcaDao() {
            return new MarcaDao();
        }

        @Override
        public PaisDao getPaisDao() {
            return new PaisDao();
        }
        @Override
        public ProdutoDao getProdutoDao() {
            return new ProdutoDao();
        }
    }

