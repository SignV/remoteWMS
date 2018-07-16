package com.signv.domain;

import java.util.ArrayList;
import java.util.List;

public class RepositoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RepositoryExample() {
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

        public Criteria andRepositoryNameIsNull() {
            addCriterion("repository_name is null");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameIsNotNull() {
            addCriterion("repository_name is not null");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameEqualTo(String value) {
            addCriterion("repository_name =", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameNotEqualTo(String value) {
            addCriterion("repository_name <>", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameGreaterThan(String value) {
            addCriterion("repository_name >", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("repository_name >=", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameLessThan(String value) {
            addCriterion("repository_name <", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameLessThanOrEqualTo(String value) {
            addCriterion("repository_name <=", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameLike(String value) {
            addCriterion("repository_name like", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameNotLike(String value) {
            addCriterion("repository_name not like", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameIn(List<String> values) {
            addCriterion("repository_name in", values, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameNotIn(List<String> values) {
            addCriterion("repository_name not in", values, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameBetween(String value1, String value2) {
            addCriterion("repository_name between", value1, value2, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameNotBetween(String value1, String value2) {
            addCriterion("repository_name not between", value1, value2, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressIsNull() {
            addCriterion("repository_address is null");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressIsNotNull() {
            addCriterion("repository_address is not null");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressEqualTo(String value) {
            addCriterion("repository_address =", value, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressNotEqualTo(String value) {
            addCriterion("repository_address <>", value, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressGreaterThan(String value) {
            addCriterion("repository_address >", value, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressGreaterThanOrEqualTo(String value) {
            addCriterion("repository_address >=", value, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressLessThan(String value) {
            addCriterion("repository_address <", value, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressLessThanOrEqualTo(String value) {
            addCriterion("repository_address <=", value, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressLike(String value) {
            addCriterion("repository_address like", value, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressNotLike(String value) {
            addCriterion("repository_address not like", value, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressIn(List<String> values) {
            addCriterion("repository_address in", values, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressNotIn(List<String> values) {
            addCriterion("repository_address not in", values, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressBetween(String value1, String value2) {
            addCriterion("repository_address between", value1, value2, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressNotBetween(String value1, String value2) {
            addCriterion("repository_address not between", value1, value2, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNull() {
            addCriterion("goods_type is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNotNull() {
            addCriterion("goods_type is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeEqualTo(String value) {
            addCriterion("goods_type =", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotEqualTo(String value) {
            addCriterion("goods_type <>", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThan(String value) {
            addCriterion("goods_type >", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_type >=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThan(String value) {
            addCriterion("goods_type <", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThanOrEqualTo(String value) {
            addCriterion("goods_type <=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLike(String value) {
            addCriterion("goods_type like", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotLike(String value) {
            addCriterion("goods_type not like", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIn(List<String> values) {
            addCriterion("goods_type in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotIn(List<String> values) {
            addCriterion("goods_type not in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeBetween(String value1, String value2) {
            addCriterion("goods_type between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotBetween(String value1, String value2) {
            addCriterion("goods_type not between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andNearbyTransportPointIsNull() {
            addCriterion("nearby_transport_point is null");
            return (Criteria) this;
        }

        public Criteria andNearbyTransportPointIsNotNull() {
            addCriterion("nearby_transport_point is not null");
            return (Criteria) this;
        }

        public Criteria andNearbyTransportPointEqualTo(String value) {
            addCriterion("nearby_transport_point =", value, "nearbyTransportPoint");
            return (Criteria) this;
        }

        public Criteria andNearbyTransportPointNotEqualTo(String value) {
            addCriterion("nearby_transport_point <>", value, "nearbyTransportPoint");
            return (Criteria) this;
        }

        public Criteria andNearbyTransportPointGreaterThan(String value) {
            addCriterion("nearby_transport_point >", value, "nearbyTransportPoint");
            return (Criteria) this;
        }

        public Criteria andNearbyTransportPointGreaterThanOrEqualTo(String value) {
            addCriterion("nearby_transport_point >=", value, "nearbyTransportPoint");
            return (Criteria) this;
        }

        public Criteria andNearbyTransportPointLessThan(String value) {
            addCriterion("nearby_transport_point <", value, "nearbyTransportPoint");
            return (Criteria) this;
        }

        public Criteria andNearbyTransportPointLessThanOrEqualTo(String value) {
            addCriterion("nearby_transport_point <=", value, "nearbyTransportPoint");
            return (Criteria) this;
        }

        public Criteria andNearbyTransportPointLike(String value) {
            addCriterion("nearby_transport_point like", value, "nearbyTransportPoint");
            return (Criteria) this;
        }

        public Criteria andNearbyTransportPointNotLike(String value) {
            addCriterion("nearby_transport_point not like", value, "nearbyTransportPoint");
            return (Criteria) this;
        }

        public Criteria andNearbyTransportPointIn(List<String> values) {
            addCriterion("nearby_transport_point in", values, "nearbyTransportPoint");
            return (Criteria) this;
        }

        public Criteria andNearbyTransportPointNotIn(List<String> values) {
            addCriterion("nearby_transport_point not in", values, "nearbyTransportPoint");
            return (Criteria) this;
        }

        public Criteria andNearbyTransportPointBetween(String value1, String value2) {
            addCriterion("nearby_transport_point between", value1, value2, "nearbyTransportPoint");
            return (Criteria) this;
        }

        public Criteria andNearbyTransportPointNotBetween(String value1, String value2) {
            addCriterion("nearby_transport_point not between", value1, value2, "nearbyTransportPoint");
            return (Criteria) this;
        }

        public Criteria andSaveTypeIsNull() {
            addCriterion("save_type is null");
            return (Criteria) this;
        }

        public Criteria andSaveTypeIsNotNull() {
            addCriterion("save_type is not null");
            return (Criteria) this;
        }

        public Criteria andSaveTypeEqualTo(String value) {
            addCriterion("save_type =", value, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeNotEqualTo(String value) {
            addCriterion("save_type <>", value, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeGreaterThan(String value) {
            addCriterion("save_type >", value, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeGreaterThanOrEqualTo(String value) {
            addCriterion("save_type >=", value, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeLessThan(String value) {
            addCriterion("save_type <", value, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeLessThanOrEqualTo(String value) {
            addCriterion("save_type <=", value, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeLike(String value) {
            addCriterion("save_type like", value, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeNotLike(String value) {
            addCriterion("save_type not like", value, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeIn(List<String> values) {
            addCriterion("save_type in", values, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeNotIn(List<String> values) {
            addCriterion("save_type not in", values, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeBetween(String value1, String value2) {
            addCriterion("save_type between", value1, value2, "saveType");
            return (Criteria) this;
        }

        public Criteria andSaveTypeNotBetween(String value1, String value2) {
            addCriterion("save_type not between", value1, value2, "saveType");
            return (Criteria) this;
        }

        public Criteria andBuiltAreaIsNull() {
            addCriterion("built_area is null");
            return (Criteria) this;
        }

        public Criteria andBuiltAreaIsNotNull() {
            addCriterion("built_area is not null");
            return (Criteria) this;
        }

        public Criteria andBuiltAreaEqualTo(String value) {
            addCriterion("built_area =", value, "builtArea");
            return (Criteria) this;
        }

        public Criteria andBuiltAreaNotEqualTo(String value) {
            addCriterion("built_area <>", value, "builtArea");
            return (Criteria) this;
        }

        public Criteria andBuiltAreaGreaterThan(String value) {
            addCriterion("built_area >", value, "builtArea");
            return (Criteria) this;
        }

        public Criteria andBuiltAreaGreaterThanOrEqualTo(String value) {
            addCriterion("built_area >=", value, "builtArea");
            return (Criteria) this;
        }

        public Criteria andBuiltAreaLessThan(String value) {
            addCriterion("built_area <", value, "builtArea");
            return (Criteria) this;
        }

        public Criteria andBuiltAreaLessThanOrEqualTo(String value) {
            addCriterion("built_area <=", value, "builtArea");
            return (Criteria) this;
        }

        public Criteria andBuiltAreaLike(String value) {
            addCriterion("built_area like", value, "builtArea");
            return (Criteria) this;
        }

        public Criteria andBuiltAreaNotLike(String value) {
            addCriterion("built_area not like", value, "builtArea");
            return (Criteria) this;
        }

        public Criteria andBuiltAreaIn(List<String> values) {
            addCriterion("built_area in", values, "builtArea");
            return (Criteria) this;
        }

        public Criteria andBuiltAreaNotIn(List<String> values) {
            addCriterion("built_area not in", values, "builtArea");
            return (Criteria) this;
        }

        public Criteria andBuiltAreaBetween(String value1, String value2) {
            addCriterion("built_area between", value1, value2, "builtArea");
            return (Criteria) this;
        }

        public Criteria andBuiltAreaNotBetween(String value1, String value2) {
            addCriterion("built_area not between", value1, value2, "builtArea");
            return (Criteria) this;
        }

        public Criteria andRepositoryStatusIsNull() {
            addCriterion("repository_status is null");
            return (Criteria) this;
        }

        public Criteria andRepositoryStatusIsNotNull() {
            addCriterion("repository_status is not null");
            return (Criteria) this;
        }

        public Criteria andRepositoryStatusEqualTo(Boolean value) {
            addCriterion("repository_status =", value, "repositoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepositoryStatusNotEqualTo(Boolean value) {
            addCriterion("repository_status <>", value, "repositoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepositoryStatusGreaterThan(Boolean value) {
            addCriterion("repository_status >", value, "repositoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepositoryStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("repository_status >=", value, "repositoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepositoryStatusLessThan(Boolean value) {
            addCriterion("repository_status <", value, "repositoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepositoryStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("repository_status <=", value, "repositoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepositoryStatusIn(List<Boolean> values) {
            addCriterion("repository_status in", values, "repositoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepositoryStatusNotIn(List<Boolean> values) {
            addCriterion("repository_status not in", values, "repositoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepositoryStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("repository_status between", value1, value2, "repositoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepositoryStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("repository_status not between", value1, value2, "repositoryStatus");
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