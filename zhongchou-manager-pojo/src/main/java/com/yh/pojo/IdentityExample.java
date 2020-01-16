package com.yh.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class IdentityExample implements Serializable{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IdentityExample() {
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

        public Criteria andUsIdentityIdIsNull() {
            addCriterion("us_identity_id is null");
            return (Criteria) this;
        }

        public Criteria andUsIdentityIdIsNotNull() {
            addCriterion("us_identity_id is not null");
            return (Criteria) this;
        }

        public Criteria andUsIdentityIdEqualTo(Integer value) {
            addCriterion("us_identity_id =", value, "usIdentityId");
            return (Criteria) this;
        }

        public Criteria andUsIdentityIdNotEqualTo(Integer value) {
            addCriterion("us_identity_id <>", value, "usIdentityId");
            return (Criteria) this;
        }

        public Criteria andUsIdentityIdGreaterThan(Integer value) {
            addCriterion("us_identity_id >", value, "usIdentityId");
            return (Criteria) this;
        }

        public Criteria andUsIdentityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("us_identity_id >=", value, "usIdentityId");
            return (Criteria) this;
        }

        public Criteria andUsIdentityIdLessThan(Integer value) {
            addCriterion("us_identity_id <", value, "usIdentityId");
            return (Criteria) this;
        }

        public Criteria andUsIdentityIdLessThanOrEqualTo(Integer value) {
            addCriterion("us_identity_id <=", value, "usIdentityId");
            return (Criteria) this;
        }

        public Criteria andUsIdentityIdIn(List<Integer> values) {
            addCriterion("us_identity_id in", values, "usIdentityId");
            return (Criteria) this;
        }

        public Criteria andUsIdentityIdNotIn(List<Integer> values) {
            addCriterion("us_identity_id not in", values, "usIdentityId");
            return (Criteria) this;
        }

        public Criteria andUsIdentityIdBetween(Integer value1, Integer value2) {
            addCriterion("us_identity_id between", value1, value2, "usIdentityId");
            return (Criteria) this;
        }

        public Criteria andUsIdentityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("us_identity_id not between", value1, value2, "usIdentityId");
            return (Criteria) this;
        }

        public Criteria andUsIdIsNull() {
            addCriterion("us_id is null");
            return (Criteria) this;
        }

        public Criteria andUsIdIsNotNull() {
            addCriterion("us_id is not null");
            return (Criteria) this;
        }

        public Criteria andUsIdEqualTo(Integer value) {
            addCriterion("us_id =", value, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdNotEqualTo(Integer value) {
            addCriterion("us_id <>", value, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdGreaterThan(Integer value) {
            addCriterion("us_id >", value, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("us_id >=", value, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdLessThan(Integer value) {
            addCriterion("us_id <", value, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdLessThanOrEqualTo(Integer value) {
            addCriterion("us_id <=", value, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdIn(List<Integer> values) {
            addCriterion("us_id in", values, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdNotIn(List<Integer> values) {
            addCriterion("us_id not in", values, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdBetween(Integer value1, Integer value2) {
            addCriterion("us_id between", value1, value2, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("us_id not between", value1, value2, "usId");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage1IsNull() {
            addCriterion("us_identity_image1 is null");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage1IsNotNull() {
            addCriterion("us_identity_image1 is not null");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage1EqualTo(String value) {
            addCriterion("us_identity_image1 =", value, "usIdentityImage1");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage1NotEqualTo(String value) {
            addCriterion("us_identity_image1 <>", value, "usIdentityImage1");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage1GreaterThan(String value) {
            addCriterion("us_identity_image1 >", value, "usIdentityImage1");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage1GreaterThanOrEqualTo(String value) {
            addCriterion("us_identity_image1 >=", value, "usIdentityImage1");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage1LessThan(String value) {
            addCriterion("us_identity_image1 <", value, "usIdentityImage1");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage1LessThanOrEqualTo(String value) {
            addCriterion("us_identity_image1 <=", value, "usIdentityImage1");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage1Like(String value) {
            addCriterion("us_identity_image1 like", value, "usIdentityImage1");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage1NotLike(String value) {
            addCriterion("us_identity_image1 not like", value, "usIdentityImage1");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage1In(List<String> values) {
            addCriterion("us_identity_image1 in", values, "usIdentityImage1");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage1NotIn(List<String> values) {
            addCriterion("us_identity_image1 not in", values, "usIdentityImage1");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage1Between(String value1, String value2) {
            addCriterion("us_identity_image1 between", value1, value2, "usIdentityImage1");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage1NotBetween(String value1, String value2) {
            addCriterion("us_identity_image1 not between", value1, value2, "usIdentityImage1");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage2IsNull() {
            addCriterion("us_identity_image2 is null");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage2IsNotNull() {
            addCriterion("us_identity_image2 is not null");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage2EqualTo(String value) {
            addCriterion("us_identity_image2 =", value, "usIdentityImage2");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage2NotEqualTo(String value) {
            addCriterion("us_identity_image2 <>", value, "usIdentityImage2");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage2GreaterThan(String value) {
            addCriterion("us_identity_image2 >", value, "usIdentityImage2");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage2GreaterThanOrEqualTo(String value) {
            addCriterion("us_identity_image2 >=", value, "usIdentityImage2");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage2LessThan(String value) {
            addCriterion("us_identity_image2 <", value, "usIdentityImage2");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage2LessThanOrEqualTo(String value) {
            addCriterion("us_identity_image2 <=", value, "usIdentityImage2");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage2Like(String value) {
            addCriterion("us_identity_image2 like", value, "usIdentityImage2");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage2NotLike(String value) {
            addCriterion("us_identity_image2 not like", value, "usIdentityImage2");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage2In(List<String> values) {
            addCriterion("us_identity_image2 in", values, "usIdentityImage2");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage2NotIn(List<String> values) {
            addCriterion("us_identity_image2 not in", values, "usIdentityImage2");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage2Between(String value1, String value2) {
            addCriterion("us_identity_image2 between", value1, value2, "usIdentityImage2");
            return (Criteria) this;
        }

        public Criteria andUsIdentityImage2NotBetween(String value1, String value2) {
            addCriterion("us_identity_image2 not between", value1, value2, "usIdentityImage2");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable{

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable{
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