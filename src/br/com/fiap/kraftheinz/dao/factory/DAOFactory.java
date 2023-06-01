package br.com.fiap.kraftheinz.dao.factory;

import br.com.fiap.kraftheinz.dao.*;

public abstract class DAOFactory {

        public static final int ORACLE = 1;

        private static DAOFactory connectionDAOFactory;

        public static DAOFactory getDAOFactory(int dataBase) {
            switch (dataBase) {
                case ORACLE: {
                    if (connectionDAOFactory == null) connectionDAOFactory = new ConnectionDAOFactory();
                    return connectionDAOFactory;
                }
                default: {
                    return null;
                }
            }
        }

        public abstract EmbalagemDao getEmbalagemDao();

        public abstract FabricaDao getFabricaDao();

        public abstract LoteDao getLoteDao();

        public abstract MarcaDao getMarcaDao();

        public abstract PaisDao getPaisDao();

        public abstract ProdutoDao getProdutoDao();



    }
