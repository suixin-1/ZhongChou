package com.yh.pojo;

import java.util.ArrayList;
import java.util.List;

public class ServiceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServiceExample() {
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

        public Criteria andSerIdIsNull() {
            addCriterion("ser_id is null");
            return (Criteria) this;
        }

        public Criteria andSerIdIsNotNull() {
            addCriterion("ser_id is not null");
            return (Criteria) this;
        }

        public Criteria andSerIdEqualTo(Integer value) {
            addCriterion("ser_id =", value, "serId");
            return (Criteria) this;
        }

        public Criteria andSerIdNotEqualTo(Integer value) {
            addCriterion("ser_id <>", value, "serId");
            return (Criteria) this;
        }

        public Criteria andSerIdGreaterThan(Integer value) {
            addCriterion("ser_id >", value, "serId");
            return (Criteria) this;
        }

        public Criteria andSerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ser_id >=", value, "serId");
            return (Criteria) this;
        }

        public Criteria andSerIdLessThan(Integer value) {
            addCriterion("ser_id <", value, "serId");
            return (Criteria) this;
        }

        public Criteria andSerIdLessThanOrEqualTo(Integer value) {
            addCriterion("ser_id <=", value, "serId");
            return (Criteria) this;
        }

        public Criteria andSerIdIn(List<Integer> values) {
            addCriterion("ser_id in", values, "serId");
            return (Criteria) this;
        }

        public Criteria andSerIdNotIn(List<Integer> values) {
            addCriterion("ser_id not in", values, "serId");
            return (Criteria) this;
        }

        public Criteria andSerIdBetween(Integer value1, Integer value2) {
            addCriterion("ser_id between", value1, value2, "serId");
            return (Criteria) this;
        }

        public Criteria andSerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ser_id not between", value1, value2, "serId");
            return (Criteria) this;
        }

        public Criteria andSerNameIsNull() {
            addCriterion("ser_name is null");
            return (Criteria) this;
        }

        public Criteria andSerNameIsNotNull() {
            addCriterion("ser_name is not null");
            return (Criteria) this;
        }

        public Criteria andSerNameEqualTo(String value) {
            addCriterion("ser_name =", value, "serName");
            return (Criteria) this;
        }

        public Criteria andSerNameNotEqualTo(String value) {
            addCriterion("ser_name <>", value, "serName");
            return (Criteria) this;
        }

        public Criteria andSerNameGreaterThan(String value) {
            addCriterion("ser_name >", value, "serName");
            return (Criteria) this;
        }

        public Criteria andSerNameGreaterThanOrEqualTo(String value) {
            addCriterion("ser_name >=", value, "serName");
            return (Criteria) this;
        }

        public Criteria andSerNameLessThan(String value) {
            addCriterion("ser_name <", value, "serName");
            return (Criteria) this;
        }

        public Criteria andSerNameLessThanOrEqualTo(String value) {
            addCriterion("ser_name <=", value, "serName");
            return (Criteria) this;
        }

        public Criteria andSerNameLike(String value) {
            addCriterion("ser_name like", value, "serName");
            return (Criteria) this;
        }

        public Criteria andSerNameNotLike(String value) {
            addCriterion("ser_name not like", value, "serName");
            return (Criteria) this;
        }

        public Criteria andSerNameIn(List<String> values) {
            addCriterion("ser_name in", values, "serName");
            return (Criteria) this;
        }

        public Criteria andSerNameNotIn(List<String> values) {
            addCriterion("ser_name not in", values, "serName");
            return (Criteria) this;
        }

        public Criteria andSerNameBetween(String value1, String value2) {
            addCriterion("ser_name between", value1, value2, "serName");
            return (Criteria) this;
        }

        public Criteria andSerNameNotBetween(String value1, String value2) {
            addCriterion("ser_name not between", value1, value2, "serName");
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