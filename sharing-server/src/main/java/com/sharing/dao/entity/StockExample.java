package com.sharing.dao.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private String sumCol;

    private Integer offset;

    private Integer limit;

    public StockExample() {
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
        this.sumCol = null;
        this.offset = null;
        this.limit = null;
    }

    public String getSumCol() {
        return this.sumCol;
    }

    public void setSumCol(String sumCol) {
        this.sumCol = sumCol;
    }

    public StockExample sumUuid() {
        this.sumCol="UUID";
        return this;
    }

    public StockExample sumInv() {
        this.sumCol="INV";
        return this;
    }

    public StockExample sumQty() {
        this.sumCol="QTY";
        return this;
    }

    public StockExample sumUseqty() {
        this.sumCol="USEQTY";
        return this;
    }

    public StockExample sumLastupdtime() {
        this.sumCol="LASTUPDTIME";
        return this;
    }

    public StockExample sumMemo() {
        this.sumCol="MEMO";
        return this;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public StockExample page(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
        return this;
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

        public Criteria andUuidIsNull() {
            addCriterion("UUID is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("UUID is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("UUID =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("UUID <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("UUID >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("UUID >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("UUID <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("UUID <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("UUID like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("UUID not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("UUID in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("UUID not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("UUID between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("UUID not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andInvIsNull() {
            addCriterion("INV is null");
            return (Criteria) this;
        }

        public Criteria andInvIsNotNull() {
            addCriterion("INV is not null");
            return (Criteria) this;
        }

        public Criteria andInvEqualTo(BigDecimal value) {
            addCriterion("INV =", value, "inv");
            return (Criteria) this;
        }

        public Criteria andInvNotEqualTo(BigDecimal value) {
            addCriterion("INV <>", value, "inv");
            return (Criteria) this;
        }

        public Criteria andInvGreaterThan(BigDecimal value) {
            addCriterion("INV >", value, "inv");
            return (Criteria) this;
        }

        public Criteria andInvGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INV >=", value, "inv");
            return (Criteria) this;
        }

        public Criteria andInvLessThan(BigDecimal value) {
            addCriterion("INV <", value, "inv");
            return (Criteria) this;
        }

        public Criteria andInvLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INV <=", value, "inv");
            return (Criteria) this;
        }

        public Criteria andInvIn(List<BigDecimal> values) {
            addCriterion("INV in", values, "inv");
            return (Criteria) this;
        }

        public Criteria andInvNotIn(List<BigDecimal> values) {
            addCriterion("INV not in", values, "inv");
            return (Criteria) this;
        }

        public Criteria andInvBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INV between", value1, value2, "inv");
            return (Criteria) this;
        }

        public Criteria andInvNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INV not between", value1, value2, "inv");
            return (Criteria) this;
        }

        public Criteria andQtyIsNull() {
            addCriterion("QTY is null");
            return (Criteria) this;
        }

        public Criteria andQtyIsNotNull() {
            addCriterion("QTY is not null");
            return (Criteria) this;
        }

        public Criteria andQtyEqualTo(BigDecimal value) {
            addCriterion("QTY =", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotEqualTo(BigDecimal value) {
            addCriterion("QTY <>", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThan(BigDecimal value) {
            addCriterion("QTY >", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY >=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThan(BigDecimal value) {
            addCriterion("QTY <", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QTY <=", value, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyIn(List<BigDecimal> values) {
            addCriterion("QTY in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotIn(List<BigDecimal> values) {
            addCriterion("QTY not in", values, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andQtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QTY not between", value1, value2, "qty");
            return (Criteria) this;
        }

        public Criteria andUseqtyIsNull() {
            addCriterion("USEQTY is null");
            return (Criteria) this;
        }

        public Criteria andUseqtyIsNotNull() {
            addCriterion("USEQTY is not null");
            return (Criteria) this;
        }

        public Criteria andUseqtyEqualTo(BigDecimal value) {
            addCriterion("USEQTY =", value, "useqty");
            return (Criteria) this;
        }

        public Criteria andUseqtyNotEqualTo(BigDecimal value) {
            addCriterion("USEQTY <>", value, "useqty");
            return (Criteria) this;
        }

        public Criteria andUseqtyGreaterThan(BigDecimal value) {
            addCriterion("USEQTY >", value, "useqty");
            return (Criteria) this;
        }

        public Criteria andUseqtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("USEQTY >=", value, "useqty");
            return (Criteria) this;
        }

        public Criteria andUseqtyLessThan(BigDecimal value) {
            addCriterion("USEQTY <", value, "useqty");
            return (Criteria) this;
        }

        public Criteria andUseqtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("USEQTY <=", value, "useqty");
            return (Criteria) this;
        }

        public Criteria andUseqtyIn(List<BigDecimal> values) {
            addCriterion("USEQTY in", values, "useqty");
            return (Criteria) this;
        }

        public Criteria andUseqtyNotIn(List<BigDecimal> values) {
            addCriterion("USEQTY not in", values, "useqty");
            return (Criteria) this;
        }

        public Criteria andUseqtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USEQTY between", value1, value2, "useqty");
            return (Criteria) this;
        }

        public Criteria andUseqtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USEQTY not between", value1, value2, "useqty");
            return (Criteria) this;
        }

        public Criteria andLastupdtimeIsNull() {
            addCriterion("LASTUPDTIME is null");
            return (Criteria) this;
        }

        public Criteria andLastupdtimeIsNotNull() {
            addCriterion("LASTUPDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastupdtimeEqualTo(Date value) {
            addCriterion("LASTUPDTIME =", value, "lastupdtime");
            return (Criteria) this;
        }

        public Criteria andLastupdtimeNotEqualTo(Date value) {
            addCriterion("LASTUPDTIME <>", value, "lastupdtime");
            return (Criteria) this;
        }

        public Criteria andLastupdtimeGreaterThan(Date value) {
            addCriterion("LASTUPDTIME >", value, "lastupdtime");
            return (Criteria) this;
        }

        public Criteria andLastupdtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LASTUPDTIME >=", value, "lastupdtime");
            return (Criteria) this;
        }

        public Criteria andLastupdtimeLessThan(Date value) {
            addCriterion("LASTUPDTIME <", value, "lastupdtime");
            return (Criteria) this;
        }

        public Criteria andLastupdtimeLessThanOrEqualTo(Date value) {
            addCriterion("LASTUPDTIME <=", value, "lastupdtime");
            return (Criteria) this;
        }

        public Criteria andLastupdtimeIn(List<Date> values) {
            addCriterion("LASTUPDTIME in", values, "lastupdtime");
            return (Criteria) this;
        }

        public Criteria andLastupdtimeNotIn(List<Date> values) {
            addCriterion("LASTUPDTIME not in", values, "lastupdtime");
            return (Criteria) this;
        }

        public Criteria andLastupdtimeBetween(Date value1, Date value2) {
            addCriterion("LASTUPDTIME between", value1, value2, "lastupdtime");
            return (Criteria) this;
        }

        public Criteria andLastupdtimeNotBetween(Date value1, Date value2) {
            addCriterion("LASTUPDTIME not between", value1, value2, "lastupdtime");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("MEMO is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("MEMO is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("MEMO =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("MEMO <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("MEMO >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("MEMO >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("MEMO <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("MEMO <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("MEMO like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("MEMO not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("MEMO in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("MEMO not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("MEMO between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("MEMO not between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria addConditionSql(String conditionSql) {
            addCriterion(conditionSql);
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