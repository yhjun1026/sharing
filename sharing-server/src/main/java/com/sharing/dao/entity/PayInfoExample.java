package com.sharing.dao.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private String sumCol;

    private Integer offset;

    private Integer limit;

    public PayInfoExample() {
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

    public PayInfoExample sumUuid() {
        this.sumCol="UUID";
        return this;
    }

    public PayInfoExample sumPayid() {
        this.sumCol="PAYID";
        return this;
    }

    public PayInfoExample sumTranstype() {
        this.sumCol="TRANSTYPE";
        return this;
    }

    public PayInfoExample sumPaytype() {
        this.sumCol="PAYTYPE";
        return this;
    }

    public PayInfoExample sumTradeno() {
        this.sumCol="TRADENO";
        return this;
    }

    public PayInfoExample sumOuttradeno() {
        this.sumCol="OUTTRADENO";
        return this;
    }

    public PayInfoExample sumPayamt() {
        this.sumCol="PAYAMT";
        return this;
    }

    public PayInfoExample sumPayuser() {
        this.sumCol="PAYUSER";
        return this;
    }

    public PayInfoExample sumPaytime() {
        this.sumCol="PAYTIME";
        return this;
    }

    public PayInfoExample sumOritradeno() {
        this.sumCol="ORITRADENO";
        return this;
    }

    public PayInfoExample sumOriouttradeno() {
        this.sumCol="ORIOUTTRADENO";
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

    public PayInfoExample page(int offset, int limit) {
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

        public Criteria andPayidIsNull() {
            addCriterion("PAYID is null");
            return (Criteria) this;
        }

        public Criteria andPayidIsNotNull() {
            addCriterion("PAYID is not null");
            return (Criteria) this;
        }

        public Criteria andPayidEqualTo(String value) {
            addCriterion("PAYID =", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotEqualTo(String value) {
            addCriterion("PAYID <>", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidGreaterThan(String value) {
            addCriterion("PAYID >", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidGreaterThanOrEqualTo(String value) {
            addCriterion("PAYID >=", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidLessThan(String value) {
            addCriterion("PAYID <", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidLessThanOrEqualTo(String value) {
            addCriterion("PAYID <=", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidLike(String value) {
            addCriterion("PAYID like", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotLike(String value) {
            addCriterion("PAYID not like", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidIn(List<String> values) {
            addCriterion("PAYID in", values, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotIn(List<String> values) {
            addCriterion("PAYID not in", values, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidBetween(String value1, String value2) {
            addCriterion("PAYID between", value1, value2, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotBetween(String value1, String value2) {
            addCriterion("PAYID not between", value1, value2, "payid");
            return (Criteria) this;
        }

        public Criteria andTranstypeIsNull() {
            addCriterion("TRANSTYPE is null");
            return (Criteria) this;
        }

        public Criteria andTranstypeIsNotNull() {
            addCriterion("TRANSTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTranstypeEqualTo(Integer value) {
            addCriterion("TRANSTYPE =", value, "transtype");
            return (Criteria) this;
        }

        public Criteria andTranstypeNotEqualTo(Integer value) {
            addCriterion("TRANSTYPE <>", value, "transtype");
            return (Criteria) this;
        }

        public Criteria andTranstypeGreaterThan(Integer value) {
            addCriterion("TRANSTYPE >", value, "transtype");
            return (Criteria) this;
        }

        public Criteria andTranstypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRANSTYPE >=", value, "transtype");
            return (Criteria) this;
        }

        public Criteria andTranstypeLessThan(Integer value) {
            addCriterion("TRANSTYPE <", value, "transtype");
            return (Criteria) this;
        }

        public Criteria andTranstypeLessThanOrEqualTo(Integer value) {
            addCriterion("TRANSTYPE <=", value, "transtype");
            return (Criteria) this;
        }

        public Criteria andTranstypeIn(List<Integer> values) {
            addCriterion("TRANSTYPE in", values, "transtype");
            return (Criteria) this;
        }

        public Criteria andTranstypeNotIn(List<Integer> values) {
            addCriterion("TRANSTYPE not in", values, "transtype");
            return (Criteria) this;
        }

        public Criteria andTranstypeBetween(Integer value1, Integer value2) {
            addCriterion("TRANSTYPE between", value1, value2, "transtype");
            return (Criteria) this;
        }

        public Criteria andTranstypeNotBetween(Integer value1, Integer value2) {
            addCriterion("TRANSTYPE not between", value1, value2, "transtype");
            return (Criteria) this;
        }

        public Criteria andPaytypeIsNull() {
            addCriterion("PAYTYPE is null");
            return (Criteria) this;
        }

        public Criteria andPaytypeIsNotNull() {
            addCriterion("PAYTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPaytypeEqualTo(Integer value) {
            addCriterion("PAYTYPE =", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotEqualTo(Integer value) {
            addCriterion("PAYTYPE <>", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeGreaterThan(Integer value) {
            addCriterion("PAYTYPE >", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PAYTYPE >=", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLessThan(Integer value) {
            addCriterion("PAYTYPE <", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLessThanOrEqualTo(Integer value) {
            addCriterion("PAYTYPE <=", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeIn(List<Integer> values) {
            addCriterion("PAYTYPE in", values, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotIn(List<Integer> values) {
            addCriterion("PAYTYPE not in", values, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeBetween(Integer value1, Integer value2) {
            addCriterion("PAYTYPE between", value1, value2, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotBetween(Integer value1, Integer value2) {
            addCriterion("PAYTYPE not between", value1, value2, "paytype");
            return (Criteria) this;
        }

        public Criteria andTradenoIsNull() {
            addCriterion("TRADENO is null");
            return (Criteria) this;
        }

        public Criteria andTradenoIsNotNull() {
            addCriterion("TRADENO is not null");
            return (Criteria) this;
        }

        public Criteria andTradenoEqualTo(String value) {
            addCriterion("TRADENO =", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoNotEqualTo(String value) {
            addCriterion("TRADENO <>", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoGreaterThan(String value) {
            addCriterion("TRADENO >", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoGreaterThanOrEqualTo(String value) {
            addCriterion("TRADENO >=", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoLessThan(String value) {
            addCriterion("TRADENO <", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoLessThanOrEqualTo(String value) {
            addCriterion("TRADENO <=", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoLike(String value) {
            addCriterion("TRADENO like", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoNotLike(String value) {
            addCriterion("TRADENO not like", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoIn(List<String> values) {
            addCriterion("TRADENO in", values, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoNotIn(List<String> values) {
            addCriterion("TRADENO not in", values, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoBetween(String value1, String value2) {
            addCriterion("TRADENO between", value1, value2, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoNotBetween(String value1, String value2) {
            addCriterion("TRADENO not between", value1, value2, "tradeno");
            return (Criteria) this;
        }

        public Criteria andOuttradenoIsNull() {
            addCriterion("OUTTRADENO is null");
            return (Criteria) this;
        }

        public Criteria andOuttradenoIsNotNull() {
            addCriterion("OUTTRADENO is not null");
            return (Criteria) this;
        }

        public Criteria andOuttradenoEqualTo(String value) {
            addCriterion("OUTTRADENO =", value, "outtradeno");
            return (Criteria) this;
        }

        public Criteria andOuttradenoNotEqualTo(String value) {
            addCriterion("OUTTRADENO <>", value, "outtradeno");
            return (Criteria) this;
        }

        public Criteria andOuttradenoGreaterThan(String value) {
            addCriterion("OUTTRADENO >", value, "outtradeno");
            return (Criteria) this;
        }

        public Criteria andOuttradenoGreaterThanOrEqualTo(String value) {
            addCriterion("OUTTRADENO >=", value, "outtradeno");
            return (Criteria) this;
        }

        public Criteria andOuttradenoLessThan(String value) {
            addCriterion("OUTTRADENO <", value, "outtradeno");
            return (Criteria) this;
        }

        public Criteria andOuttradenoLessThanOrEqualTo(String value) {
            addCriterion("OUTTRADENO <=", value, "outtradeno");
            return (Criteria) this;
        }

        public Criteria andOuttradenoLike(String value) {
            addCriterion("OUTTRADENO like", value, "outtradeno");
            return (Criteria) this;
        }

        public Criteria andOuttradenoNotLike(String value) {
            addCriterion("OUTTRADENO not like", value, "outtradeno");
            return (Criteria) this;
        }

        public Criteria andOuttradenoIn(List<String> values) {
            addCriterion("OUTTRADENO in", values, "outtradeno");
            return (Criteria) this;
        }

        public Criteria andOuttradenoNotIn(List<String> values) {
            addCriterion("OUTTRADENO not in", values, "outtradeno");
            return (Criteria) this;
        }

        public Criteria andOuttradenoBetween(String value1, String value2) {
            addCriterion("OUTTRADENO between", value1, value2, "outtradeno");
            return (Criteria) this;
        }

        public Criteria andOuttradenoNotBetween(String value1, String value2) {
            addCriterion("OUTTRADENO not between", value1, value2, "outtradeno");
            return (Criteria) this;
        }

        public Criteria andPayamtIsNull() {
            addCriterion("PAYAMT is null");
            return (Criteria) this;
        }

        public Criteria andPayamtIsNotNull() {
            addCriterion("PAYAMT is not null");
            return (Criteria) this;
        }

        public Criteria andPayamtEqualTo(BigDecimal value) {
            addCriterion("PAYAMT =", value, "payamt");
            return (Criteria) this;
        }

        public Criteria andPayamtNotEqualTo(BigDecimal value) {
            addCriterion("PAYAMT <>", value, "payamt");
            return (Criteria) this;
        }

        public Criteria andPayamtGreaterThan(BigDecimal value) {
            addCriterion("PAYAMT >", value, "payamt");
            return (Criteria) this;
        }

        public Criteria andPayamtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PAYAMT >=", value, "payamt");
            return (Criteria) this;
        }

        public Criteria andPayamtLessThan(BigDecimal value) {
            addCriterion("PAYAMT <", value, "payamt");
            return (Criteria) this;
        }

        public Criteria andPayamtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PAYAMT <=", value, "payamt");
            return (Criteria) this;
        }

        public Criteria andPayamtIn(List<BigDecimal> values) {
            addCriterion("PAYAMT in", values, "payamt");
            return (Criteria) this;
        }

        public Criteria andPayamtNotIn(List<BigDecimal> values) {
            addCriterion("PAYAMT not in", values, "payamt");
            return (Criteria) this;
        }

        public Criteria andPayamtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAYAMT between", value1, value2, "payamt");
            return (Criteria) this;
        }

        public Criteria andPayamtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAYAMT not between", value1, value2, "payamt");
            return (Criteria) this;
        }

        public Criteria andPayuserIsNull() {
            addCriterion("PAYUSER is null");
            return (Criteria) this;
        }

        public Criteria andPayuserIsNotNull() {
            addCriterion("PAYUSER is not null");
            return (Criteria) this;
        }

        public Criteria andPayuserEqualTo(String value) {
            addCriterion("PAYUSER =", value, "payuser");
            return (Criteria) this;
        }

        public Criteria andPayuserNotEqualTo(String value) {
            addCriterion("PAYUSER <>", value, "payuser");
            return (Criteria) this;
        }

        public Criteria andPayuserGreaterThan(String value) {
            addCriterion("PAYUSER >", value, "payuser");
            return (Criteria) this;
        }

        public Criteria andPayuserGreaterThanOrEqualTo(String value) {
            addCriterion("PAYUSER >=", value, "payuser");
            return (Criteria) this;
        }

        public Criteria andPayuserLessThan(String value) {
            addCriterion("PAYUSER <", value, "payuser");
            return (Criteria) this;
        }

        public Criteria andPayuserLessThanOrEqualTo(String value) {
            addCriterion("PAYUSER <=", value, "payuser");
            return (Criteria) this;
        }

        public Criteria andPayuserLike(String value) {
            addCriterion("PAYUSER like", value, "payuser");
            return (Criteria) this;
        }

        public Criteria andPayuserNotLike(String value) {
            addCriterion("PAYUSER not like", value, "payuser");
            return (Criteria) this;
        }

        public Criteria andPayuserIn(List<String> values) {
            addCriterion("PAYUSER in", values, "payuser");
            return (Criteria) this;
        }

        public Criteria andPayuserNotIn(List<String> values) {
            addCriterion("PAYUSER not in", values, "payuser");
            return (Criteria) this;
        }

        public Criteria andPayuserBetween(String value1, String value2) {
            addCriterion("PAYUSER between", value1, value2, "payuser");
            return (Criteria) this;
        }

        public Criteria andPayuserNotBetween(String value1, String value2) {
            addCriterion("PAYUSER not between", value1, value2, "payuser");
            return (Criteria) this;
        }

        public Criteria andPaytimeIsNull() {
            addCriterion("PAYTIME is null");
            return (Criteria) this;
        }

        public Criteria andPaytimeIsNotNull() {
            addCriterion("PAYTIME is not null");
            return (Criteria) this;
        }

        public Criteria andPaytimeEqualTo(Date value) {
            addCriterion("PAYTIME =", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotEqualTo(Date value) {
            addCriterion("PAYTIME <>", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeGreaterThan(Date value) {
            addCriterion("PAYTIME >", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PAYTIME >=", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeLessThan(Date value) {
            addCriterion("PAYTIME <", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeLessThanOrEqualTo(Date value) {
            addCriterion("PAYTIME <=", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeIn(List<Date> values) {
            addCriterion("PAYTIME in", values, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotIn(List<Date> values) {
            addCriterion("PAYTIME not in", values, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeBetween(Date value1, Date value2) {
            addCriterion("PAYTIME between", value1, value2, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotBetween(Date value1, Date value2) {
            addCriterion("PAYTIME not between", value1, value2, "paytime");
            return (Criteria) this;
        }

        public Criteria andOritradenoIsNull() {
            addCriterion("ORITRADENO is null");
            return (Criteria) this;
        }

        public Criteria andOritradenoIsNotNull() {
            addCriterion("ORITRADENO is not null");
            return (Criteria) this;
        }

        public Criteria andOritradenoEqualTo(String value) {
            addCriterion("ORITRADENO =", value, "oritradeno");
            return (Criteria) this;
        }

        public Criteria andOritradenoNotEqualTo(String value) {
            addCriterion("ORITRADENO <>", value, "oritradeno");
            return (Criteria) this;
        }

        public Criteria andOritradenoGreaterThan(String value) {
            addCriterion("ORITRADENO >", value, "oritradeno");
            return (Criteria) this;
        }

        public Criteria andOritradenoGreaterThanOrEqualTo(String value) {
            addCriterion("ORITRADENO >=", value, "oritradeno");
            return (Criteria) this;
        }

        public Criteria andOritradenoLessThan(String value) {
            addCriterion("ORITRADENO <", value, "oritradeno");
            return (Criteria) this;
        }

        public Criteria andOritradenoLessThanOrEqualTo(String value) {
            addCriterion("ORITRADENO <=", value, "oritradeno");
            return (Criteria) this;
        }

        public Criteria andOritradenoLike(String value) {
            addCriterion("ORITRADENO like", value, "oritradeno");
            return (Criteria) this;
        }

        public Criteria andOritradenoNotLike(String value) {
            addCriterion("ORITRADENO not like", value, "oritradeno");
            return (Criteria) this;
        }

        public Criteria andOritradenoIn(List<String> values) {
            addCriterion("ORITRADENO in", values, "oritradeno");
            return (Criteria) this;
        }

        public Criteria andOritradenoNotIn(List<String> values) {
            addCriterion("ORITRADENO not in", values, "oritradeno");
            return (Criteria) this;
        }

        public Criteria andOritradenoBetween(String value1, String value2) {
            addCriterion("ORITRADENO between", value1, value2, "oritradeno");
            return (Criteria) this;
        }

        public Criteria andOritradenoNotBetween(String value1, String value2) {
            addCriterion("ORITRADENO not between", value1, value2, "oritradeno");
            return (Criteria) this;
        }

        public Criteria andOriouttradenoIsNull() {
            addCriterion("ORIOUTTRADENO is null");
            return (Criteria) this;
        }

        public Criteria andOriouttradenoIsNotNull() {
            addCriterion("ORIOUTTRADENO is not null");
            return (Criteria) this;
        }

        public Criteria andOriouttradenoEqualTo(String value) {
            addCriterion("ORIOUTTRADENO =", value, "oriouttradeno");
            return (Criteria) this;
        }

        public Criteria andOriouttradenoNotEqualTo(String value) {
            addCriterion("ORIOUTTRADENO <>", value, "oriouttradeno");
            return (Criteria) this;
        }

        public Criteria andOriouttradenoGreaterThan(String value) {
            addCriterion("ORIOUTTRADENO >", value, "oriouttradeno");
            return (Criteria) this;
        }

        public Criteria andOriouttradenoGreaterThanOrEqualTo(String value) {
            addCriterion("ORIOUTTRADENO >=", value, "oriouttradeno");
            return (Criteria) this;
        }

        public Criteria andOriouttradenoLessThan(String value) {
            addCriterion("ORIOUTTRADENO <", value, "oriouttradeno");
            return (Criteria) this;
        }

        public Criteria andOriouttradenoLessThanOrEqualTo(String value) {
            addCriterion("ORIOUTTRADENO <=", value, "oriouttradeno");
            return (Criteria) this;
        }

        public Criteria andOriouttradenoLike(String value) {
            addCriterion("ORIOUTTRADENO like", value, "oriouttradeno");
            return (Criteria) this;
        }

        public Criteria andOriouttradenoNotLike(String value) {
            addCriterion("ORIOUTTRADENO not like", value, "oriouttradeno");
            return (Criteria) this;
        }

        public Criteria andOriouttradenoIn(List<String> values) {
            addCriterion("ORIOUTTRADENO in", values, "oriouttradeno");
            return (Criteria) this;
        }

        public Criteria andOriouttradenoNotIn(List<String> values) {
            addCriterion("ORIOUTTRADENO not in", values, "oriouttradeno");
            return (Criteria) this;
        }

        public Criteria andOriouttradenoBetween(String value1, String value2) {
            addCriterion("ORIOUTTRADENO between", value1, value2, "oriouttradeno");
            return (Criteria) this;
        }

        public Criteria andOriouttradenoNotBetween(String value1, String value2) {
            addCriterion("ORIOUTTRADENO not between", value1, value2, "oriouttradeno");
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