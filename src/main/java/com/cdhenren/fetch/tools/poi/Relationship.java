package com.cdhenren.fetch.tools.poi;

import com.cdhenren.fetch.entity.enhancer.SysTableRelationship;

import java.util.List;
import java.util.Map;

/**
 * @author Fuhj
 * @date 2019.09.28
 */
public class Relationship {

    private List<SysTableRelationship> relationships;
    private Map<String, Class> propertiesMap;

    public Relationship() {

    }

    public Relationship(List<SysTableRelationship> relationships) {
        this.relationships = relationships;
    }

    public List<SysTableRelationship> getRelationships() {
        return relationships;
    }

    public Map<String, Class> getPropertiesMap() {
        return propertiesMap;
    }

    public void setPropertiesMap(Map<String, Class> propertiesMap) {
        this.propertiesMap = propertiesMap;
    }

    public void setRelationships(List<SysTableRelationship> relationships) {
        this.relationships = relationships;
    }

}
