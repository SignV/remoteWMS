package com.signv.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OutInStatisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OutInStatisticsExample() {
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

        public Criteria andOutInIdIsNull() {
            addCriterion("out_in_id is null");
            return (Criteria) this;
        }

        public Criteria andOutInIdIsNotNull() {
            addCriterion("out_in_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutInIdEqualTo(Integer value) {
            addCriterion("out_in_id =", value, "outInId");
            return (Criteria) this;
        }

        public Criteria andOutInIdNotEqualTo(Integer value) {
            addCriterion("out_in_id <>", value, "outInId");
            return (Criteria) this;
        }

        public Criteria andOutInIdGreaterThan(Integer value) {
            addCriterion("out_in_id >", value, "outInId");
            return (Criteria) this;
        }

        public Criteria andOutInIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("out_in_id >=", value, "outInId");
            return (Criteria) this;
        }

        public Criteria andOutInIdLessThan(Integer value) {
            addCriterion("out_in_id <", value, "outInId");
            return (Criteria) this;
        }

        public Criteria andOutInIdLessThanOrEqualTo(Integer value) {
            addCriterion("out_in_id <=", value, "outInId");
            return (Criteria) this;
        }

        public Criteria andOutInIdIn(List<Integer> values) {
            addCriterion("out_in_id in", values, "outInId");
            return (Criteria) this;
        }

        public Criteria andOutInIdNotIn(List<Integer> values) {
            addCriterion("out_in_id not in", values, "outInId");
            return (Criteria) this;
        }

        public Criteria andOutInIdBetween(Integer value1, Integer value2) {
            addCriterion("out_in_id between", value1, value2, "outInId");
            return (Criteria) this;
        }

        public Criteria andOutInIdNotBetween(Integer value1, Integer value2) {
            addCriterion("out_in_id not between", value1, value2, "outInId");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsIdIsNull() {
            addCriterion("out_in_goods_id is null");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsIdIsNotNull() {
            addCriterion("out_in_goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsIdEqualTo(Integer value) {
            addCriterion("out_in_goods_id =", value, "outInGoodsId");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsIdNotEqualTo(Integer value) {
            addCriterion("out_in_goods_id <>", value, "outInGoodsId");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsIdGreaterThan(Integer value) {
            addCriterion("out_in_goods_id >", value, "outInGoodsId");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("out_in_goods_id >=", value, "outInGoodsId");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsIdLessThan(Integer value) {
            addCriterion("out_in_goods_id <", value, "outInGoodsId");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("out_in_goods_id <=", value, "outInGoodsId");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsIdIn(List<Integer> values) {
            addCriterion("out_in_goods_id in", values, "outInGoodsId");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsIdNotIn(List<Integer> values) {
            addCriterion("out_in_goods_id not in", values, "outInGoodsId");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("out_in_goods_id between", value1, value2, "outInGoodsId");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("out_in_goods_id not between", value1, value2, "outInGoodsId");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsNameIsNull() {
            addCriterion("out_in_goods_name is null");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsNameIsNotNull() {
            addCriterion("out_in_goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsNameEqualTo(String value) {
            addCriterion("out_in_goods_name =", value, "outInGoodsName");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsNameNotEqualTo(String value) {
            addCriterion("out_in_goods_name <>", value, "outInGoodsName");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsNameGreaterThan(String value) {
            addCriterion("out_in_goods_name >", value, "outInGoodsName");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("out_in_goods_name >=", value, "outInGoodsName");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsNameLessThan(String value) {
            addCriterion("out_in_goods_name <", value, "outInGoodsName");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("out_in_goods_name <=", value, "outInGoodsName");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsNameLike(String value) {
            addCriterion("out_in_goods_name like", value, "outInGoodsName");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsNameNotLike(String value) {
            addCriterion("out_in_goods_name not like", value, "outInGoodsName");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsNameIn(List<String> values) {
            addCriterion("out_in_goods_name in", values, "outInGoodsName");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsNameNotIn(List<String> values) {
            addCriterion("out_in_goods_name not in", values, "outInGoodsName");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsNameBetween(String value1, String value2) {
            addCriterion("out_in_goods_name between", value1, value2, "outInGoodsName");
            return (Criteria) this;
        }

        public Criteria andOutInGoodsNameNotBetween(String value1, String value2) {
            addCriterion("out_in_goods_name not between", value1, value2, "outInGoodsName");
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

        public Criteria andOutInStatusIsNull() {
            addCriterion("out_in_status is null");
            return (Criteria) this;
        }

        public Criteria andOutInStatusIsNotNull() {
            addCriterion("out_in_status is not null");
            return (Criteria) this;
        }

        public Criteria andOutInStatusEqualTo(Boolean value) {
            addCriterion("out_in_status =", value, "outInStatus");
            return (Criteria) this;
        }

        public Criteria andOutInStatusNotEqualTo(Boolean value) {
            addCriterion("out_in_status <>", value, "outInStatus");
            return (Criteria) this;
        }

        public Criteria andOutInStatusGreaterThan(Boolean value) {
            addCriterion("out_in_status >", value, "outInStatus");
            return (Criteria) this;
        }

        public Criteria andOutInStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("out_in_status >=", value, "outInStatus");
            return (Criteria) this;
        }

        public Criteria andOutInStatusLessThan(Boolean value) {
            addCriterion("out_in_status <", value, "outInStatus");
            return (Criteria) this;
        }

        public Criteria andOutInStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("out_in_status <=", value, "outInStatus");
            return (Criteria) this;
        }

        public Criteria andOutInStatusIn(List<Boolean> values) {
            addCriterion("out_in_status in", values, "outInStatus");
            return (Criteria) this;
        }

        public Criteria andOutInStatusNotIn(List<Boolean> values) {
            addCriterion("out_in_status not in", values, "outInStatus");
            return (Criteria) this;
        }

        public Criteria andOutInStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("out_in_status between", value1, value2, "outInStatus");
            return (Criteria) this;
        }

        public Criteria andOutInStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("out_in_status not between", value1, value2, "outInStatus");
            return (Criteria) this;
        }

        public Criteria andOutInAmountIsNull() {
            addCriterion("out_in_amount is null");
            return (Criteria) this;
        }

        public Criteria andOutInAmountIsNotNull() {
            addCriterion("out_in_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOutInAmountEqualTo(Double value) {
            addCriterion("out_in_amount =", value, "outInAmount");
            return (Criteria) this;
        }

        public Criteria andOutInAmountNotEqualTo(Double value) {
            addCriterion("out_in_amount <>", value, "outInAmount");
            return (Criteria) this;
        }

        public Criteria andOutInAmountGreaterThan(Double value) {
            addCriterion("out_in_amount >", value, "outInAmount");
            return (Criteria) this;
        }

        public Criteria andOutInAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("out_in_amount >=", value, "outInAmount");
            return (Criteria) this;
        }

        public Criteria andOutInAmountLessThan(Double value) {
            addCriterion("out_in_amount <", value, "outInAmount");
            return (Criteria) this;
        }

        public Criteria andOutInAmountLessThanOrEqualTo(Double value) {
            addCriterion("out_in_amount <=", value, "outInAmount");
            return (Criteria) this;
        }

        public Criteria andOutInAmountIn(List<Double> values) {
            addCriterion("out_in_amount in", values, "outInAmount");
            return (Criteria) this;
        }

        public Criteria andOutInAmountNotIn(List<Double> values) {
            addCriterion("out_in_amount not in", values, "outInAmount");
            return (Criteria) this;
        }

        public Criteria andOutInAmountBetween(Double value1, Double value2) {
            addCriterion("out_in_amount between", value1, value2, "outInAmount");
            return (Criteria) this;
        }

        public Criteria andOutInAmountNotBetween(Double value1, Double value2) {
            addCriterion("out_in_amount not between", value1, value2, "outInAmount");
            return (Criteria) this;
        }

        public Criteria andOutInDateIsNull() {
            addCriterion("out_in_date is null");
            return (Criteria) this;
        }

        public Criteria andOutInDateIsNotNull() {
            addCriterion("out_in_date is not null");
            return (Criteria) this;
        }

        public Criteria andOutInDateEqualTo(Date value) {
            addCriterion("out_in_date =", value, "outInDate");
            return (Criteria) this;
        }

        public Criteria andOutInDateNotEqualTo(Date value) {
            addCriterion("out_in_date <>", value, "outInDate");
            return (Criteria) this;
        }

        public Criteria andOutInDateGreaterThan(Date value) {
            addCriterion("out_in_date >", value, "outInDate");
            return (Criteria) this;
        }

        public Criteria andOutInDateGreaterThanOrEqualTo(Date value) {
            addCriterion("out_in_date >=", value, "outInDate");
            return (Criteria) this;
        }

        public Criteria andOutInDateLessThan(Date value) {
            addCriterion("out_in_date <", value, "outInDate");
            return (Criteria) this;
        }

        public Criteria andOutInDateLessThanOrEqualTo(Date value) {
            addCriterion("out_in_date <=", value, "outInDate");
            return (Criteria) this;
        }

        public Criteria andOutInDateIn(List<Date> values) {
            addCriterion("out_in_date in", values, "outInDate");
            return (Criteria) this;
        }

        public Criteria andOutInDateNotIn(List<Date> values) {
            addCriterion("out_in_date not in", values, "outInDate");
            return (Criteria) this;
        }

        public Criteria andOutInDateBetween(Date value1, Date value2) {
            addCriterion("out_in_date between", value1, value2, "outInDate");
            return (Criteria) this;
        }

        public Criteria andOutInDateNotBetween(Date value1, Date value2) {
            addCriterion("out_in_date not between", value1, value2, "outInDate");
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