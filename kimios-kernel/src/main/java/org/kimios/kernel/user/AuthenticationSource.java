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
package org.kimios.kernel.user;

import org.kimios.exceptions.ConfigException;
import org.kimios.kernel.exception.DataSourceException;

/**
 * This class provides methods to handle all implemented authentication sources
 *
 * @author jludmann
 */
public interface AuthenticationSource
{
    public String getName();

    public void setName(String sourceName);

    public org.kimios.kernel.ws.pojo.AuthenticationSource toPojo();

    public UserFactory getUserFactory() throws DataSourceException, ConfigException;

    public GroupFactory getGroupFactory() throws DataSourceException, ConfigException;

    public Boolean getEnableSSOCheck();

    public void setEnableSSOCheck(Boolean check);

    public Boolean getEnableAuthByEmail();

    public void setEnableAuthByEmail(Boolean check);
}

