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

package org.kimios.kernel.controller;

import org.kimios.kernel.converter.exception.ConverterException;
import org.kimios.kernel.converter.source.InputSource;
import org.kimios.kernel.security.Session;

import java.util.List;

public interface IConverterController {

    /**
     * Check current document access, create input source from last version of document,
     * get the appropriate converter by factory call, execute the convert process
     * and return a JAX RS response.
     */
    InputSource convertDocument(Session session, Long documentId, String converterImpl) throws ConverterException;

    /**
     * Check current document access, create input source from document version,
     * get the appropriate converter by factory call, execute the convert process
     * and return a JAX RS response.
     */
    InputSource convertDocumentVersion(Session session, Long documentVersionId, String converterImpl) throws ConverterException;

    /**
     * Check document accesses, create multi input sources from last versions of documents,
     * get the appropriate converter by factory call, execute the convert process
     * and return a JAX RS response.
     */
    InputSource convertDocuments(Session session, List<Long> documentIds, String converterImpl) throws ConverterException;


    /**
     * Check document accesses, create multi input sources from versions,
     * get the appropriate converter by factory call, execute the convert process
     * and return a JAX RS response.
     */
    InputSource convertDocumentVersions(Session session, List<Long> documentVersionIds, String converterImpl) throws ConverterException;

}
