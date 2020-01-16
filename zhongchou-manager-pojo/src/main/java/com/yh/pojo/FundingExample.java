package com.yh.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FundingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FundingExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andFdIdIsNull() {
            addCriterion("fd_id is null");
            return (Criteria) this;
        }

        public Criteria andFdIdIsNotNull() {
            addCriterion("fd_id is not null");
            return (Criteria) this;
        }

        public Criteria andFdIdEqualTo(Integer value) {
            addCriterion("fd_id =", value, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdNotEqualTo(Integer value) {
            addCriterion("fd_id <>", value, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdGreaterThan(Integer value) {
            addCriterion("fd_id >", value, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fd_id >=", value, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdLessThan(Integer value) {
            addCriterion("fd_id <", value, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdLessThanOrEqualTo(Integer value) {
            addCriterion("fd_id <=", value, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdIn(List<Integer> values) {
            addCriterion("fd_id in", values, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdNotIn(List<Integer> values) {
            addCriterion("fd_id not in", values, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdBetween(Integer value1, Integer value2) {
            addCriterion("fd_id between", value1, value2, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fd_id not between", value1, value2, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdUsIdIsNull() {
            addCriterion("fd_us_id is null");
            return (Criteria) this;
        }

        public Criteria andFdUsIdIsNotNull() {
            addCriterion("fd_us_id is not null");
            return (Criteria) this;
        }

        public Criteria andFdUsIdEqualTo(Integer value) {
            addCriterion("fd_us_id =", value, "fdUsId");
            return (Criteria) this;
        }

        public Criteria andFdUsIdNotEqualTo(Integer value) {
            addCriterion("fd_us_id <>", value, "fdUsId");
            return (Criteria) this;
        }

        public Criteria andFdUsIdGreaterThan(Integer value) {
            addCriterion("fd_us_id >", value, "fdUsId");
            return (Criteria) this;
        }

        public Criteria andFdUsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fd_us_id >=", value, "fdUsId");
            return (Criteria) this;
        }

        public Criteria andFdUsIdLessThan(Integer value) {
            addCriterion("fd_us_id <", value, "fdUsId");
            return (Criteria) this;
        }

        public Criteria andFdUsIdLessThanOrEqualTo(Integer value) {
            addCriterion("fd_us_id <=", value, "fdUsId");
            return (Criteria) this;
        }

        public Criteria andFdUsIdIn(List<Integer> values) {
            addCriterion("fd_us_id in", values, "fdUsId");
            return (Criteria) this;
        }

        public Criteria andFdUsIdNotIn(List<Integer> values) {
            addCriterion("fd_us_id not in", values, "fdUsId");
            return (Criteria) this;
        }

        public Criteria andFdUsIdBetween(Integer value1, Integer value2) {
            addCriterion("fd_us_id between", value1, value2, "fdUsId");
            return (Criteria) this;
        }

        public Criteria andFdUsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fd_us_id not between", value1, value2, "fdUsId");
            return (Criteria) this;
        }

        public Criteria andFdPsIdIsNull() {
            addCriterion("fd_ps_id is null");
            return (Criteria) this;
        }

        public Criteria andFdPsIdIsNotNull() {
            addCriterion("fd_ps_id is not null");
            return (Criteria) this;
        }

        public Criteria andFdPsIdEqualTo(Integer value) {
            addCriterion("fd_ps_id =", value, "fdPsId");
            return (Criteria) this;
        }

        public Criteria andFdPsIdNotEqualTo(Integer value) {
            addCriterion("fd_ps_id <>", value, "fdPsId");
            return (Criteria) this;
        }

        public Criteria andFdPsIdGreaterThan(Integer value) {
            addCriterion("fd_ps_id >", value, "fdPsId");
            return (Criteria) this;
        }

        public Criteria andFdPsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fd_ps_id >=", value, "fdPsId");
            return (Criteria) this;
        }

        public Criteria andFdPsIdLessThan(Integer value) {
            addCriterion("fd_ps_id <", value, "fdPsId");
            return (Criteria) this;
        }

        public Criteria andFdPsIdLessThanOrEqualTo(Integer value) {
            addCriterion("fd_ps_id <=", value, "fdPsId");
            return (Criteria) this;
        }

        public Criteria andFdPsIdIn(List<Integer> values) {
            addCriterion("fd_ps_id in", values, "fdPsId");
            return (Criteria) this;
        }

        public Criteria andFdPsIdNotIn(List<Integer> values) {
            addCriterion("fd_ps_id not in", values, "fdPsId");
            return (Criteria) this;
        }

        public Criteria andFdPsIdBetween(Integer value1, Integer value2) {
            addCriterion("fd_ps_id between", value1, value2, "fdPsId");
            return (Criteria) this;
        }

        public Criteria andFdPsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fd_ps_id not between", value1, value2, "fdPsId");
            return (Criteria) this;
        }

        public Criteria andFdMoneyIsNull() {
            addCriterion("fd_money is null");
            return (Criteria) this;
        }

        public Criteria andFdMoneyIsNotNull() {
            addCriterion("fd_money is not null");
            return (Criteria) this;
        }

        public Criteria andFdMoneyEqualTo(Double value) {
            addCriterion("fd_money =", value, "fdMoney");
            return (Criteria) this;
        }

        public Criteria andFdMoneyNotEqualTo(Double value) {
            addCriterion("fd_money <>", value, "fdMoney");
            return (Criteria) this;
        }

        public Criteria andFdMoneyGreaterThan(Double value) {
            addCriterion("fd_money >", value, "fdMoney");
            return (Criteria) this;
        }

        public Criteria andFdMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("fd_money >=", value, "fdMoney");
            return (Criteria) this;
        }

        public Criteria andFdMoneyLessThan(Double value) {
            addCriterion("fd_money <", value, "fdMoney");
            return (Criteria) this;
        }

        public Criteria andFdMoneyLessThanOrEqualTo(Double value) {
            addCriterion("fd_money <=", value, "fdMoney");
            return (Criteria) this;
        }

        public Criteria andFdMoneyIn(List<Double> values) {
            addCriterion("fd_money in", values, "fdMoney");
            return (Criteria) this;
        }

        public Criteria andFdMoneyNotIn(List<Double> values) {
            addCriterion("fd_money not in", values, "fdMoney");
            return (Criteria) this;
        }

        public Criteria andFdMoneyBetween(Double value1, Double value2) {
            addCriterion("fd_money between", value1, value2, "fdMoney");
            return (Criteria) this;
        }

        public Criteria andFdMoneyNotBetween(Double value1, Double value2) {
            addCriterion("fd_money not between", value1, value2, "fdMoney");
            return (Criteria) this;
        }

        public Criteria andFdTimeIsNull() {
            addCriterion("fd_time is null");
            return (Criteria) this;
        }

        public Criteria andFdTimeIsNotNull() {
            addCriterion("fd_time is not null");
            return (Criteria) this;
        }

        public Criteria andFdTimeEqualTo(Date value) {
            addCriterionForJDBCDate("fd_time =", value, "fdTime");
            return (Criteria) this;
        }

        public Criteria andFdTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("fd_time <>", value, "fdTime");
            return (Criteria) this;
        }

        public Criteria andFdTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("fd_time >", value, "fdTime");
            return (Criteria) this;
        }

        public Criteria andFdTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fd_time >=", value, "fdTime");
            return (Criteria) this;
        }

        public Criteria andFdTimeLessThan(Date value) {
            addCriterionForJDBCDate("fd_time <", value, "fdTime");
            return (Criteria) this;
        }

        public Criteria andFdTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fd_time <=", value, "fdTime");
            return (Criteria) this;
        }

        public Criteria andFdTimeIn(List<Date> values) {
            addCriterionForJDBCDate("fd_time in", values, "fdTime");
            return (Criteria) this;
        }

        public Criteria andFdTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("fd_time not in", values, "fdTime");
            return (Criteria) this;
        }

        public Criteria andFdTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fd_time between", value1, value2, "fdTime");
            return (Criteria) this;
        }

        public Criteria andFdTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fd_time not between", value1, value2, "fdTime");
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