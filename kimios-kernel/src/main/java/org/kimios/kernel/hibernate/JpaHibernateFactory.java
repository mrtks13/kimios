/*
 * Kimios - Document Management System Software
 * Copyright (C) 2008-2015  DevLib'
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * aong with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.kimios.kernel.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

/**
 * Created by farf on 6/14/14.
 *                            P
 * Used to provide direct hibernate session, from
 * a Hibernate JPA EntityManager
 *
 * Give the ability to use Hibernate in JPA Mode,
 * especially in an OSGI Context
 *
 *
 */
public class JpaHibernateFactory extends AbstractDBFactory  {



    private static Logger logger = LoggerFactory.getLogger(JpaHibernateFactory.class);

    private EntityManager entityManager;

    private SessionFactory sessionFactory;

    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public SessionFactory getSessionFactory() {
        Session session = entityManager.unwrap(org.hibernate.Session.class);
        return session.getSessionFactory();
    }

    @Override
    public Session getSession(boolean autoCommitSession) {
        Session session = entityManager.unwrap(org.hibernate.Session.class);
        if (autoCommitSession) {
            return session.getSessionFactory().openSession();
        } else {
            return session;
        }
    }

    @Override
    public Session getSession() {
        return entityManager.unwrap(org.hibernate.Session.class);
    }


    synchronized static public IDBFactory getInstance()
    {
        if (instance == null) {
            instance = new JpaHibernateFactory();
        }
        return instance;
    }
}
