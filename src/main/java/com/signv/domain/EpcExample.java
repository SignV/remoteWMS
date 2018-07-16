package com.signv.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EpcExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EpcExample() {
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

        public Criteria andEpcIdIsNull() {
            addCriterion("epc_id is null");
            return (Criteria) this;
        }

        public Criteria andEpcIdIsNotNull() {
            addCriterion("epc_id is not null");
            return (Criteria) this;
        }

        public Criteria andEpcIdEqualTo(Integer value) {
            addCriterion("epc_id =", value, "epcId");
            return (Criteria) this;
        }

        public Criteria andEpcIdNotEqualTo(Integer value) {
            addCriterion("epc_id <>", value, "epcId");
            return (Criteria) this;
        }

        public Criteria andEpcIdGreaterThan(Integer value) {
            addCriterion("epc_id >", value, "epcId");
            return (Criteria) this;
        }

        public Criteria andEpcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("epc_id >=", value, "epcId");
            return (Criteria) this;
        }

        public Criteria andEpcIdLessThan(Integer value) {
            addCriterion("epc_id <", value, "epcId");
            return (Criteria) this;
        }

        public Criteria andEpcIdLessThanOrEqualTo(Integer value) {
            addCriterion("epc_id <=", value, "epcId");
            return (Criteria) this;
        }

        public Criteria andEpcIdIn(List<Integer> values) {
            addCriterion("epc_id in", values, "epcId");
            return (Criteria) this;
        }

        public Criteria andEpcIdNotIn(List<Integer> values) {
            addCriterion("epc_id not in", values, "epcId");
            return (Criteria) this;
        }

        public Criteria andEpcIdBetween(Integer value1, Integer value2) {
            addCriterion("epc_id between", value1, value2, "epcId");
            return (Criteria) this;
        }

        public Criteria andEpcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("epc_id not between", value1, value2, "epcId");
            return (Criteria) this;
        }

        public Criteria andEpcCodeIsNull() {
            addCriterion("epc_code is null");
            return (Criteria) this;
        }

        public Criteria andEpcCodeIsNotNull() {
            addCriterion("epc_code is not null");
            return (Criteria) this;
        }

        public Criteria andEpcCodeEqualTo(String value) {
            addCriterion("epc_code =", value, "epcCode");
            return (Criteria) this;
        }

        public Criteria andEpcCodeNotEqualTo(String value) {
            addCriterion("epc_code <>", value, "epcCode");
            return (Criteria) this;
        }

        public Criteria andEpcCodeGreaterThan(String value) {
            addCriterion("epc_code >", value, "epcCode");
            return (Criteria) this;
        }

        public Criteria andEpcCodeGreaterThanOrEqualTo(String value) {
            addCriterion("epc_code >=", value, "epcCode");
            return (Criteria) this;
        }

        public Criteria andEpcCodeLessThan(String value) {
            addCriterion("epc_code <", value, "epcCode");
            return (Criteria) this;
        }

        public Criteria andEpcCodeLessThanOrEqualTo(String value) {
            addCriterion("epc_code <=", value, "epcCode");
            return (Criteria) this;
        }

        public Criteria andEpcCodeLike(String value) {
            addCriterion("epc_code like", value, "epcCode");
            return (Criteria) this;
        }

        public Criteria andEpcCodeNotLike(String value) {
            addCriterion("epc_code not like", value, "epcCode");
            return (Criteria) this;
        }

        public Criteria andEpcCodeIn(List<String> values) {
            addCriterion("epc_code in", values, "epcCode");
            return (Criteria) this;
        }

        public Criteria andEpcCodeNotIn(List<String> values) {
            addCriterion("epc_code not in", values, "epcCode");
            return (Criteria) this;
        }

        public Criteria andEpcCodeBetween(String value1, String value2) {
            addCriterion("epc_code between", value1, value2, "epcCode");
            return (Criteria) this;
        }

        public Criteria andEpcCodeNotBetween(String value1, String value2) {
            addCriterion("epc_code not between", value1, value2, "epcCode");
            return (Criteria) this;
        }

        public Criteria andEpcGoodsIdIsNull() {
            addCriterion("epc_goods_id is null");
            return (Criteria) this;
        }

        public Criteria andEpcGoodsIdIsNotNull() {
            addCriterion("epc_goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andEpcGoodsIdEqualTo(Integer value) {
            addCriterion("epc_goods_id =", value, "epcGoodsId");
            return (Criteria) this;
        }

        public Criteria andEpcGoodsIdNotEqualTo(Integer value) {
            addCriterion("epc_goods_id <>", value, "epcGoodsId");
            return (Criteria) this;
        }

        public Criteria andEpcGoodsIdGreaterThan(Integer value) {
            addCriterion("epc_goods_id >", value, "epcGoodsId");
            return (Criteria) this;
        }

        public Criteria andEpcGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("epc_goods_id >=", value, "epcGoodsId");
            return (Criteria) this;
        }

        public Criteria andEpcGoodsIdLessThan(Integer value) {
            addCriterion("epc_goods_id <", value, "epcGoodsId");
            return (Criteria) this;
        }

        public Criteria andEpcGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("epc_goods_id <=", value, "epcGoodsId");
            return (Criteria) this;
        }

        public Criteria andEpcGoodsIdIn(List<Integer> values) {
            addCriterion("epc_goods_id in", values, "epcGoodsId");
            return (Criteria) this;
        }

        public Criteria andEpcGoodsIdNotIn(List<Integer> values) {
            addCriterion("epc_goods_id not in", values, "epcGoodsId");
            return (Criteria) this;
        }

        public Criteria andEpcGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("epc_goods_id between", value1, value2, "epcGoodsId");
            return (Criteria) this;
        }

        public Criteria andEpcGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("epc_goods_id not between", value1, value2, "epcGoodsId");
            return (Criteria) this;
        }

        public Criteria andOutInNumIsNull() {
            addCriterion("out_in_num is null");
            return (Criteria) this;
        }

        public Criteria andOutInNumIsNotNull() {
            addCriterion("out_in_num is not null");
            return (Criteria) this;
        }

        public Criteria andOutInNumEqualTo(Integer value) {
            addCriterion("out_in_num =", value, "outInNum");
            return (Criteria) this;
        }

        public Criteria andOutInNumNotEqualTo(Integer value) {
            addCriterion("out_in_num <>", value, "outInNum");
            return (Criteria) this;
        }

        public Criteria andOutInNumGreaterThan(Integer value) {
            addCriterion("out_in_num >", value, "outInNum");
            return (Criteria) this;
        }

        public Criteria andOutInNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("out_in_num >=", value, "outInNum");
            return (Criteria) this;
        }

        public Criteria andOutInNumLessThan(Integer value) {
            addCriterion("out_in_num <", value, "outInNum");
            return (Criteria) this;
        }

        public Criteria andOutInNumLessThanOrEqualTo(Integer value) {
            addCriterion("out_in_num <=", value, "outInNum");
            return (Criteria) this;
        }

        public Criteria andOutInNumIn(List<Integer> values) {
            addCriterion("out_in_num in", values, "outInNum");
            return (Criteria) this;
        }

        public Criteria andOutInNumNotIn(List<Integer> values) {
            addCriterion("out_in_num not in", values, "outInNum");
            return (Criteria) this;
        }

        public Criteria andOutInNumBetween(Integer value1, Integer value2) {
            addCriterion("out_in_num between", value1, value2, "outInNum");
            return (Criteria) this;
        }

        public Criteria andOutInNumNotBetween(Integer value1, Integer value2) {
            addCriterion("out_in_num not between", value1, value2, "outInNum");
            return (Criteria) this;
        }

        public Criteria andEpcStatusIsNull() {
            addCriterion("epc_status is null");
            return (Criteria) this;
        }

        public Criteria andEpcStatusIsNotNull() {
            addCriterion("epc_status is not null");
            return (Criteria) this;
        }

        public Criteria andEpcStatusEqualTo(Integer value) {
            addCriterion("epc_status =", value, "epcStatus");
            return (Criteria) this;
        }

        public Criteria andEpcStatusNotEqualTo(Integer value) {
            addCriterion("epc_status <>", value, "epcStatus");
            return (Criteria) this;
        }

        public Criteria andEpcStatusGreaterThan(Integer value) {
            addCriterion("epc_status >", value, "epcStatus");
            return (Criteria) this;
        }

        public Criteria andEpcStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("epc_status >=", value, "epcStatus");
            return (Criteria) this;
        }

        public Criteria andEpcStatusLessThan(Integer value) {
            addCriterion("epc_status <", value, "epcStatus");
            return (Criteria) this;
        }

        public Criteria andEpcStatusLessThanOrEqualTo(Integer value) {
            addCriterion("epc_status <=", value, "epcStatus");
            return (Criteria) this;
        }

        public Criteria andEpcStatusIn(List<Integer> values) {
            addCriterion("epc_status in", values, "epcStatus");
            return (Criteria) this;
        }

        public Criteria andEpcStatusNotIn(List<Integer> values) {
            addCriterion("epc_status not in", values, "epcStatus");
            return (Criteria) this;
        }

        public Criteria andEpcStatusBetween(Integer value1, Integer value2) {
            addCriterion("epc_status between", value1, value2, "epcStatus");
            return (Criteria) this;
        }

        public Criteria andEpcStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("epc_status not between", value1, value2, "epcStatus");
            return (Criteria) this;
        }

        public Criteria andEpcDateIsNull() {
            addCriterion("epc_date is null");
            return (Criteria) this;
        }

        public Criteria andEpcDateIsNotNull() {
            addCriterion("epc_date is not null");
            return (Criteria) this;
        }

        public Criteria andEpcDateEqualTo(Date value) {
            addCriterion("epc_date =", value, "epcDate");
            return (Criteria) this;
        }

        public Criteria andEpcDateNotEqualTo(Date value) {
            addCriterion("epc_date <>", value, "epcDate");
            return (Criteria) this;
        }

        public Criteria andEpcDateGreaterThan(Date value) {
            addCriterion("epc_date >", value, "epcDate");
            return (Criteria) this;
        }

        public Criteria andEpcDateGreaterThanOrEqualTo(Date value) {
            addCriterion("epc_date >=", value, "epcDate");
            return (Criteria) this;
        }

        public Criteria andEpcDateLessThan(Date value) {
            addCriterion("epc_date <", value, "epcDate");
            return (Criteria) this;
        }

        public Criteria andEpcDateLessThanOrEqualTo(Date value) {
            addCriterion("epc_date <=", value, "epcDate");
            return (Criteria) this;
        }

        public Criteria andEpcDateIn(List<Date> values) {
            addCriterion("epc_date in", values, "epcDate");
            return (Criteria) this;
        }

        public Criteria andEpcDateNotIn(List<Date> values) {
            addCriterion("epc_date not in", values, "epcDate");
            return (Criteria) this;
        }

        public Criteria andEpcDateBetween(Date value1, Date value2) {
            addCriterion("epc_date between", value1, value2, "epcDate");
            return (Criteria) this;
        }

        public Criteria andEpcDateNotBetween(Date value1, Date value2) {
            addCriterion("epc_date not between", value1, value2, "epcDate");
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