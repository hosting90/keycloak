/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.keycloak.services.clientpolicy.condition;

import java.util.List;

import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.provider.ProviderConfigProperty;

public class ClientRolesConditionFactory extends AbstractClientPolicyConditionProviderFactory {

    public static final String PROVIDER_ID = "clientroles-condition";
    public static final String ROLES = "roles";

    private static final ProviderConfigProperty CLIENTROLES_PROPERTY = new ProviderConfigProperty(
            ROLES, PROVIDER_ID + ".label", PROVIDER_ID + ".tooltip", ProviderConfigProperty.MULTIVALUED_STRING_TYPE, null);

    @Override
    public ClientPolicyConditionProvider create(KeycloakSession session, ComponentModel model) {
        return new ClientRolesCondition(session, model);
    }

    @Override
    public String getId() {
        return PROVIDER_ID;
    }

    @Override
    public String getHelpText() {
        return "The condition checks whether one of the specified client roles is applied to the client to determine whether the policy is applied.";
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        List<ProviderConfigProperty> l = super.getConfigProperties();
        l.add(CLIENTROLES_PROPERTY);
        return l;
    }
}
