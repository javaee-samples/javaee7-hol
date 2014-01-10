/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package org.javaee7.movieplex7.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Arun Gupta
 */
@Entity
@Table(name = "TIMESLOT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timeslot.findAll", query = "SELECT t FROM Timeslot t"),
    @NamedQuery(name = "Timeslot.findById", query = "SELECT t FROM Timeslot t WHERE t.id = :id"),
    @NamedQuery(name = "Timeslot.findByStartTime", query = "SELECT t FROM Timeslot t WHERE t.startTime = :startTime"),
    @NamedQuery(name = "Timeslot.findByEndTime", query = "SELECT t FROM Timeslot t WHERE t.endTime = :endTime")})
public class Timeslot implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    private Integer id;
    
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "START_TIME")
    private String startTime;
    
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "END_TIME")
    private String endTime;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timingId")
    private Collection<ShowTiming> showTimingCollection;

    public Timeslot() {
    }

    public Timeslot(Integer id) {
        this.id = id;
    }

    public Timeslot(Integer id, String startTime, String endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @XmlTransient
    public Collection<ShowTiming> getShowTimingCollection() {
        return showTimingCollection;
    }

    public void setShowTimingCollection(Collection<ShowTiming> showTimingCollection) {
        this.showTimingCollection = showTimingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timeslot)) {
            return false;
        }
        Timeslot other = (Timeslot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return startTime;
    }
    
}
