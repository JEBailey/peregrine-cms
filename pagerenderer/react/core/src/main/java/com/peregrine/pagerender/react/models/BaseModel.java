package com.peregrine.pagerender.react.models;

/*-
 * #%L
 * peregrine vuejs page renderer - Core
 * %%
 * Copyright (C) 2017 headwire inc.
 * %%
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * #L%
 */

import com.peregrine.nodetypes.models.AbstractComponent;
import com.peregrine.nodetypes.models.IComponent;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

import static com.peregrine.commons.util.PerConstants.JACKSON;
import static com.peregrine.commons.util.PerConstants.JSON;
import static com.peregrine.pagerender.react.models.PageRenderReactConstants.PR_REACT_COMPONENT_BASE_TYPE;

/**
 * Created by rr on 4/18/2017.
 */
@Model(adaptables = Resource.class,
       resourceType = PR_REACT_COMPONENT_BASE_TYPE,
       defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
       adapters = IComponent.class)
@Exporter(name = JACKSON,
          extensions = JSON)
public class BaseModel
    extends AbstractComponent {

    @Inject
    @Default(values = "")
    private String text;

    public BaseModel(Resource resource) {
        super(resource);
    }


    public String getText() {
        return text == null ? "" : text;
    }

}
