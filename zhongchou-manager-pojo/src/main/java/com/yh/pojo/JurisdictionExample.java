package com.yh.pojo;

import java.util.ArrayList;
import java.util.List;

public class JurisdictionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JurisdictionExample() {
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

        public Criteria andJuIdIsNull() {
            addCriterion("ju_id is null");
            return (Criteria) this;
        }

        public Criteria andJuIdIsNotNull() {
            addCriterion("ju_id is not null");
            return (Criteria) this;
        }

        public Criteria andJuIdEqualTo(Integer value) {
            addCriterion("ju_id =", value, "juId");
            return (Criteria) this;
        }

        public Criteria andJuIdNotEqualTo(Integer value) {
            addCriterion("ju_id <>", value, "juId");
            return (Criteria) this;
        }

        public Criteria andJuIdGreaterThan(Integer value) {
            addCriterion("ju_id >", value, "juId");
            return (Criteria) this;
        }

        public Criteria andJuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ju_id >=", value, "juId");
            return (Criteria) this;
        }

        public Criteria andJuIdLessThan(Integer value) {
            addCriterion("ju_id <", value, "juId");
            return (Criteria) this;
        }

        public Criteria andJuIdLessThanOrEqualTo(Integer value) {
            addCriterion("ju_id <=", value, "juId");
            return (Criteria) this;
        }

        public Criteria andJuIdIn(List<Integer> values) {
            addCriterion("ju_id in", values, "juId");
            return (Criteria) this;
        }

        public Criteria andJuIdNotIn(List<Integer> values) {
            addCriterion("ju_id not in", values, "juId");
            return (Criteria) this;
        }

        public Criteria andJuIdBetween(Integer value1, Integer value2) {
            addCriterion("ju_id between", value1, value2, "juId");
            return (Criteria) this;
        }

        public Criteria andJuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ju_id not between", value1, value2, "juId");
            return (Criteria) this;
        }

        public Criteria andJuAdIdIsNull() {
            addCriterion("ju_ad_id is null");
            return (Criteria) this;
        }

        public Criteria andJuAdIdIsNotNull() {
            addCriterion("ju_ad_id is not null");
            return (Criteria) this;
        }

        public Criteria andJuAdIdEqualTo(Integer value) {
            addCriterion("ju_ad_id =", value, "juAdId");
            return (Criteria) this;
        }

        public Criteria andJuAdIdNotEqualTo(Integer value) {
            addCriterion("ju_ad_id <>", value, "juAdId");
            return (Criteria) this;
        }

        public Criteria andJuAdIdGreaterThan(Integer value) {
            addCriterion("ju_ad_id >", value, "juAdId");
            return (Criteria) this;
        }

        public Criteria andJuAdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ju_ad_id >=", value, "juAdId");
            return (Criteria) this;
        }

        public Criteria andJuAdIdLessThan(Integer value) {
            addCriterion("ju_ad_id <", value, "juAdId");
            return (Criteria) this;
        }

        public Criteria andJuAdIdLessThanOrEqualTo(Integer value) {
            addCriterion("ju_ad_id <=", value, "juAdId");
            return (Criteria) this;
        }

        public Criteria andJuAdIdIn(List<Integer> values) {
            addCriterion("ju_ad_id in", values, "juAdId");
            return (Criteria) this;
        }

        public Criteria andJuAdIdNotIn(List<Integer> values) {
            addCriterion("ju_ad_id not in", values, "juAdId");
            return (Criteria) this;
        }

        public Criteria andJuAdIdBetween(Integer value1, Integer value2) {
            addCriterion("ju_ad_id between", value1, value2, "juAdId");
            return (Criteria) this;
        }

        public Criteria andJuAdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ju_ad_id not between", value1, value2, "juAdId");
            return (Criteria) this;
        }

        public Criteria andJuNameIsNull() {
            addCriterion("ju_name is null");
            return (Criteria) this;
        }

        public Criteria andJuNameIsNotNull() {
            addCriterion("ju_name is not null");
            return (Criteria) this;
        }

        public Criteria andJuNameEqualTo(String value) {
            addCriterion("ju_name =", value, "juName");
            return (Criteria) this;
        }

        public Criteria andJuNameNotEqualTo(String value) {
            addCriterion("ju_name <>", value, "juName");
            return (Criteria) this;
        }

        public Criteria andJuNameGreaterThan(String value) {
            addCriterion("ju_name >", value, "juName");
            return (Criteria) this;
        }

        public Criteria andJuNameGreaterThanOrEqualTo(String value) {
            addCriterion("ju_name >=", value, "juName");
            return (Criteria) this;
        }

        public Criteria andJuNameLessThan(String value) {
            addCriterion("ju_name <", value, "juName");
            return (Criteria) this;
        }

        public Criteria andJuNameLessThanOrEqualTo(String value) {
            addCriterion("ju_name <=", value, "juName");
            return (Criteria) this;
        }

        public Criteria andJuNameLike(String value) {
            addCriterion("ju_name like", value, "juName");
            return (Criteria) this;
        }

        public Criteria andJuNameNotLike(String value) {
            addCriterion("ju_name not like", value, "juName");
            return (Criteria) this;
        }

        public Criteria andJuNameIn(List<String> values) {
            addCriterion("ju_name in", values, "juName");
            return (Criteria) this;
        }

        public Criteria andJuNameNotIn(List<String> values) {
            addCriterion("ju_name not in", values, "juName");
            return (Criteria) this;
        }

        public Criteria andJuNameBetween(String value1, String value2) {
            addCriterion("ju_name between", value1, value2, "juName");
            return (Criteria) this;
        }

        public Criteria andJuNameNotBetween(String value1, String value2) {
            addCriterion("ju_name not between", value1, value2, "juName");
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