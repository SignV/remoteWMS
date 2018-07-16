package com.signv.domain;

import java.util.ArrayList;
import java.util.List;

public class HumidityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HumidityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andHumidityNumIsNull() {
            addCriterion("humidity_num is null");
            return (Criteria) this;
        }

        public Criteria andHumidityNumIsNotNull() {
            addCriterion("humidity_num is not null");
            return (Criteria) this;
        }

        public Criteria andHumidityNumEqualTo(Integer value) {
            addCriterion("humidity_num =", value, "humidityNum");
            return (Criteria) this;
        }

        public Criteria andHumidityNumNotEqualTo(Integer value) {
            addCriterion("humidity_num <>", value, "humidityNum");
            return (Criteria) this;
        }

        public Criteria andHumidityNumGreaterThan(Integer value) {
            addCriterion("humidity_num >", value, "humidityNum");
            return (Criteria) this;
        }

        public Criteria andHumidityNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("humidity_num >=", value, "humidityNum");
            return (Criteria) this;
        }

        public Criteria andHumidityNumLessThan(Integer value) {
            addCriterion("humidity_num <", value, "humidityNum");
            return (Criteria) this;
        }

        public Criteria andHumidityNumLessThanOrEqualTo(Integer value) {
            addCriterion("humidity_num <=", value, "humidityNum");
            return (Criteria) this;
        }

        public Criteria andHumidityNumIn(List<Integer> values) {
            addCriterion("humidity_num in", values, "humidityNum");
            return (Criteria) this;
        }

        public Criteria andHumidityNumNotIn(List<Integer> values) {
            addCriterion("humidity_num not in", values, "humidityNum");
            return (Criteria) this;
        }

        public Criteria andHumidityNumBetween(Integer value1, Integer value2) {
            addCriterion("humidity_num between", value1, value2, "humidityNum");
            return (Criteria) this;
        }

        public Criteria andHumidityNumNotBetween(Integer value1, Integer value2) {
            addCriterion("humidity_num not between", value1, value2, "humidityNum");
            return (Criteria) this;
        }

        public Criteria andRepositoryNumIsNull() {
            addCriterion("repository_num is null");
            return (Criteria) this;
        }

        public Criteria andRepositoryNumIsNotNull() {
            addCriterion("repository_num is not null");
            return (Criteria) this;
        }

        public Criteria andRepositoryNumEqualTo(Integer value) {
            addCriterion("repository_num =", value, "repositoryNum");
            return (Criteria) this;
        }

        public Criteria andRepositoryNumNotEqualTo(Integer value) {
            addCriterion("repository_num <>", value, "repositoryNum");
            return (Criteria) this;
        }

        public Criteria andRepositoryNumGreaterThan(Integer value) {
            addCriterion("repository_num >", value, "repositoryNum");
            return (Criteria) this;
        }

        public Criteria andRepositoryNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("repository_num >=", value, "repositoryNum");
            return (Criteria) this;
        }

        public Criteria andRepositoryNumLessThan(Integer value) {
            addCriterion("repository_num <", value, "repositoryNum");
            return (Criteria) this;
        }

        public Criteria andRepositoryNumLessThanOrEqualTo(Integer value) {
            addCriterion("repository_num <=", value, "repositoryNum");
            return (Criteria) this;
        }

        public Criteria andRepositoryNumIn(List<Integer> values) {
            addCriterion("repository_num in", values, "repositoryNum");
            return (Criteria) this;
        }

        public Criteria andRepositoryNumNotIn(List<Integer> values) {
            addCriterion("repository_num not in", values, "repositoryNum");
            return (Criteria) this;
        }

        public Criteria andRepositoryNumBetween(Integer value1, Integer value2) {
            addCriterion("repository_num between", value1, value2, "repositoryNum");
            return (Criteria) this;
        }

        public Criteria andRepositoryNumNotBetween(Integer value1, Integer value2) {
            addCriterion("repository_num not between", value1, value2, "repositoryNum");
            return (Criteria) this;
        }

        public Criteria andSensorNumIsNull() {
            addCriterion("sensor_num is null");
            return (Criteria) this;
        }

        public Criteria andSensorNumIsNotNull() {
            addCriterion("sensor_num is not null");
            return (Criteria) this;
        }

        public Criteria andSensorNumEqualTo(Integer value) {
            addCriterion("sensor_num =", value, "sensorNum");
            return (Criteria) this;
        }

        public Criteria andSensorNumNotEqualTo(Integer value) {
            addCriterion("sensor_num <>", value, "sensorNum");
            return (Criteria) this;
        }

        public Criteria andSensorNumGreaterThan(Integer value) {
            addCriterion("sensor_num >", value, "sensorNum");
            return (Criteria) this;
        }

        public Criteria andSensorNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("sensor_num >=", value, "sensorNum");
            return (Criteria) this;
        }

        public Criteria andSensorNumLessThan(Integer value) {
            addCriterion("sensor_num <", value, "sensorNum");
            return (Criteria) this;
        }

        public Criteria andSensorNumLessThanOrEqualTo(Integer value) {
            addCriterion("sensor_num <=", value, "sensorNum");
            return (Criteria) this;
        }

        public Criteria andSensorNumIn(List<Integer> values) {
            addCriterion("sensor_num in", values, "sensorNum");
            return (Criteria) this;
        }

        public Criteria andSensorNumNotIn(List<Integer> values) {
            addCriterion("sensor_num not in", values, "sensorNum");
            return (Criteria) this;
        }

        public Criteria andSensorNumBetween(Integer value1, Integer value2) {
            addCriterion("sensor_num between", value1, value2, "sensorNum");
            return (Criteria) this;
        }

        public Criteria andSensorNumNotBetween(Integer value1, Integer value2) {
            addCriterion("sensor_num not between", value1, value2, "sensorNum");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}