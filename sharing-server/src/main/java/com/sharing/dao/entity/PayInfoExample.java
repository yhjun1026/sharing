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
        this.sumCol="uuid";
        return this;
    }

    public PayInfoExample sumPayId() {
        this.sumCol="pay_id";
        return this;
    }

    public PayInfoExample sumTransType() {
        this.sumCol="trans_type";
        return this;
    }

    public PayInfoExample sumPayType() {
        this.sumCol="pay_type";
        return this;
    }

    public PayInfoExample sumTradeNo() {
        this.sumCol="trade_no";
        return this;
    }

    public PayInfoExample sumOutTradeNo() {
        this.sumCol="out_trade_no";
        return this;
    }

    public PayInfoExample sumPayAmt() {
        this.sumCol="pay_amt";
        return this;
    }

    public PayInfoExample sumPayUser() {
        this.sumCol="pay_user";
        return this;
    }

    public PayInfoExample sumPayTime() {
        this.sumCol="pay_time";
        return this;
    }

    public PayInfoExample sumOriTradeNo() {
        this.sumCol="ori_trade_no";
        return this;
    }

    public PayInfoExample sumOriOutTradeNo() {
        this.sumCol="ori_out_trade_no";
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
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andPayIdIsNull() {
            addCriterion("pay_id is null");
            return (Criteria) this;
        }

        public Criteria andPayIdIsNotNull() {
            addCriterion("pay_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayIdEqualTo(String value) {
            addCriterion("pay_id =", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotEqualTo(String value) {
            addCriterion("pay_id <>", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdGreaterThan(String value) {
            addCriterion("pay_id >", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdGreaterThanOrEqualTo(String value) {
            addCriterion("pay_id >=", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLessThan(String value) {
            addCriterion("pay_id <", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLessThanOrEqualTo(String value) {
            addCriterion("pay_id <=", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLike(String value) {
            addCriterion("pay_id like", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotLike(String value) {
            addCriterion("pay_id not like", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdIn(List<String> values) {
            addCriterion("pay_id in", values, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotIn(List<String> values) {
            addCriterion("pay_id not in", values, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdBetween(String value1, String value2) {
            addCriterion("pay_id between", value1, value2, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotBetween(String value1, String value2) {
            addCriterion("pay_id not between", value1, value2, "payId");
            return (Criteria) this;
        }

        public Criteria andTransTypeIsNull() {
            addCriterion("trans_type is null");
            return (Criteria) this;
        }

        public Criteria andTransTypeIsNotNull() {
            addCriterion("trans_type is not null");
            return (Criteria) this;
        }

        public Criteria andTransTypeEqualTo(Integer value) {
            addCriterion("trans_type =", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotEqualTo(Integer value) {
            addCriterion("trans_type <>", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeGreaterThan(Integer value) {
            addCriterion("trans_type >", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("trans_type >=", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeLessThan(Integer value) {
            addCriterion("trans_type <", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeLessThanOrEqualTo(Integer value) {
            addCriterion("trans_type <=", value, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeIn(List<Integer> values) {
            addCriterion("trans_type in", values, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotIn(List<Integer> values) {
            addCriterion("trans_type not in", values, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeBetween(Integer value1, Integer value2) {
            addCriterion("trans_type between", value1, value2, "transType");
            return (Criteria) this;
        }

        public Criteria andTransTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("trans_type not between", value1, value2, "transType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Integer value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Integer value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Integer value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Integer value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Integer> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Integer> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNull() {
            addCriterion("trade_no is null");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNotNull() {
            addCriterion("trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNoEqualTo(String value) {
            addCriterion("trade_no =", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotEqualTo(String value) {
            addCriterion("trade_no <>", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThan(String value) {
            addCriterion("trade_no >", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("trade_no >=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThan(String value) {
            addCriterion("trade_no <", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThanOrEqualTo(String value) {
            addCriterion("trade_no <=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLike(String value) {
            addCriterion("trade_no like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotLike(String value) {
            addCriterion("trade_no not like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIn(List<String> values) {
            addCriterion("trade_no in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotIn(List<String> values) {
            addCriterion("trade_no not in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoBetween(String value1, String value2) {
            addCriterion("trade_no between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotBetween(String value1, String value2) {
            addCriterion("trade_no not between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIsNull() {
            addCriterion("out_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIsNotNull() {
            addCriterion("out_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoEqualTo(String value) {
            addCriterion("out_trade_no =", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotEqualTo(String value) {
            addCriterion("out_trade_no <>", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThan(String value) {
            addCriterion("out_trade_no >", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("out_trade_no >=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThan(String value) {
            addCriterion("out_trade_no <", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThanOrEqualTo(String value) {
            addCriterion("out_trade_no <=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLike(String value) {
            addCriterion("out_trade_no like", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotLike(String value) {
            addCriterion("out_trade_no not like", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIn(List<String> values) {
            addCriterion("out_trade_no in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotIn(List<String> values) {
            addCriterion("out_trade_no not in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoBetween(String value1, String value2) {
            addCriterion("out_trade_no between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotBetween(String value1, String value2) {
            addCriterion("out_trade_no not between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andPayAmtIsNull() {
            addCriterion("pay_amt is null");
            return (Criteria) this;
        }

        public Criteria andPayAmtIsNotNull() {
            addCriterion("pay_amt is not null");
            return (Criteria) this;
        }

        public Criteria andPayAmtEqualTo(BigDecimal value) {
            addCriterion("pay_amt =", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtNotEqualTo(BigDecimal value) {
            addCriterion("pay_amt <>", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtGreaterThan(BigDecimal value) {
            addCriterion("pay_amt >", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_amt >=", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtLessThan(BigDecimal value) {
            addCriterion("pay_amt <", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_amt <=", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtIn(List<BigDecimal> values) {
            addCriterion("pay_amt in", values, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtNotIn(List<BigDecimal> values) {
            addCriterion("pay_amt not in", values, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_amt between", value1, value2, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_amt not between", value1, value2, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayUserIsNull() {
            addCriterion("pay_user is null");
            return (Criteria) this;
        }

        public Criteria andPayUserIsNotNull() {
            addCriterion("pay_user is not null");
            return (Criteria) this;
        }

        public Criteria andPayUserEqualTo(String value) {
            addCriterion("pay_user =", value, "payUser");
            return (Criteria) this;
        }

        public Criteria andPayUserNotEqualTo(String value) {
            addCriterion("pay_user <>", value, "payUser");
            return (Criteria) this;
        }

        public Criteria andPayUserGreaterThan(String value) {
            addCriterion("pay_user >", value, "payUser");
            return (Criteria) this;
        }

        public Criteria andPayUserGreaterThanOrEqualTo(String value) {
            addCriterion("pay_user >=", value, "payUser");
            return (Criteria) this;
        }

        public Criteria andPayUserLessThan(String value) {
            addCriterion("pay_user <", value, "payUser");
            return (Criteria) this;
        }

        public Criteria andPayUserLessThanOrEqualTo(String value) {
            addCriterion("pay_user <=", value, "payUser");
            return (Criteria) this;
        }

        public Criteria andPayUserLike(String value) {
            addCriterion("pay_user like", value, "payUser");
            return (Criteria) this;
        }

        public Criteria andPayUserNotLike(String value) {
            addCriterion("pay_user not like", value, "payUser");
            return (Criteria) this;
        }

        public Criteria andPayUserIn(List<String> values) {
            addCriterion("pay_user in", values, "payUser");
            return (Criteria) this;
        }

        public Criteria andPayUserNotIn(List<String> values) {
            addCriterion("pay_user not in", values, "payUser");
            return (Criteria) this;
        }

        public Criteria andPayUserBetween(String value1, String value2) {
            addCriterion("pay_user between", value1, value2, "payUser");
            return (Criteria) this;
        }

        public Criteria andPayUserNotBetween(String value1, String value2) {
            addCriterion("pay_user not between", value1, value2, "payUser");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andOriTradeNoIsNull() {
            addCriterion("ori_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andOriTradeNoIsNotNull() {
            addCriterion("ori_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andOriTradeNoEqualTo(String value) {
            addCriterion("ori_trade_no =", value, "oriTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriTradeNoNotEqualTo(String value) {
            addCriterion("ori_trade_no <>", value, "oriTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriTradeNoGreaterThan(String value) {
            addCriterion("ori_trade_no >", value, "oriTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("ori_trade_no >=", value, "oriTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriTradeNoLessThan(String value) {
            addCriterion("ori_trade_no <", value, "oriTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriTradeNoLessThanOrEqualTo(String value) {
            addCriterion("ori_trade_no <=", value, "oriTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriTradeNoLike(String value) {
            addCriterion("ori_trade_no like", value, "oriTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriTradeNoNotLike(String value) {
            addCriterion("ori_trade_no not like", value, "oriTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriTradeNoIn(List<String> values) {
            addCriterion("ori_trade_no in", values, "oriTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriTradeNoNotIn(List<String> values) {
            addCriterion("ori_trade_no not in", values, "oriTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriTradeNoBetween(String value1, String value2) {
            addCriterion("ori_trade_no between", value1, value2, "oriTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriTradeNoNotBetween(String value1, String value2) {
            addCriterion("ori_trade_no not between", value1, value2, "oriTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriOutTradeNoIsNull() {
            addCriterion("ori_out_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andOriOutTradeNoIsNotNull() {
            addCriterion("ori_out_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andOriOutTradeNoEqualTo(String value) {
            addCriterion("ori_out_trade_no =", value, "oriOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriOutTradeNoNotEqualTo(String value) {
            addCriterion("ori_out_trade_no <>", value, "oriOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriOutTradeNoGreaterThan(String value) {
            addCriterion("ori_out_trade_no >", value, "oriOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriOutTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("ori_out_trade_no >=", value, "oriOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriOutTradeNoLessThan(String value) {
            addCriterion("ori_out_trade_no <", value, "oriOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriOutTradeNoLessThanOrEqualTo(String value) {
            addCriterion("ori_out_trade_no <=", value, "oriOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriOutTradeNoLike(String value) {
            addCriterion("ori_out_trade_no like", value, "oriOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriOutTradeNoNotLike(String value) {
            addCriterion("ori_out_trade_no not like", value, "oriOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriOutTradeNoIn(List<String> values) {
            addCriterion("ori_out_trade_no in", values, "oriOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriOutTradeNoNotIn(List<String> values) {
            addCriterion("ori_out_trade_no not in", values, "oriOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriOutTradeNoBetween(String value1, String value2) {
            addCriterion("ori_out_trade_no between", value1, value2, "oriOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andOriOutTradeNoNotBetween(String value1, String value2) {
            addCriterion("ori_out_trade_no not between", value1, value2, "oriOutTradeNo");
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