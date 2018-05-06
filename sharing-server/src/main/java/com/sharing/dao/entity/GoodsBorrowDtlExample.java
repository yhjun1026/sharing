package com.sharing.dao.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GoodsBorrowDtlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private String sumCol;

    private Integer offset;

    private Integer limit;

    public GoodsBorrowDtlExample() {
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

    public GoodsBorrowDtlExample sumUuid() {
        this.sumCol="UUID";
        return this;
    }

    public GoodsBorrowDtlExample sumGoodsuuid() {
        this.sumCol="GOODSUUID";
        return this;
    }

    public GoodsBorrowDtlExample sumGoodscode() {
        this.sumCol="GOODSCODE";
        return this;
    }

    public GoodsBorrowDtlExample sumGoodsname() {
        this.sumCol="GOODSNAME";
        return this;
    }

    public GoodsBorrowDtlExample sumBorrowqty() {
        this.sumCol="BORROWQTY";
        return this;
    }

    public GoodsBorrowDtlExample sumBorrowdescrip() {
        this.sumCol="BORROWDESCRIP";
        return this;
    }

    public GoodsBorrowDtlExample sumDepositamt() {
        this.sumCol="DEPOSITAMT";
        return this;
    }

    public GoodsBorrowDtlExample sumDamaged() {
        this.sumCol="DAMAGED";
        return this;
    }

    public GoodsBorrowDtlExample sumReturndescrip() {
        this.sumCol="RETURNDESCRIP";
        return this;
    }

    public GoodsBorrowDtlExample sumBackqty() {
        this.sumCol="BACKQTY";
        return this;
    }

    public GoodsBorrowDtlExample sumPayamt() {
        this.sumCol="PAYAMT";
        return this;
    }

    public GoodsBorrowDtlExample sumBackdepositamt() {
        this.sumCol="BACKDEPOSITAMT";
        return this;
    }

    public GoodsBorrowDtlExample sumMemo() {
        this.sumCol="MEMO";
        return this;
    }

    public GoodsBorrowDtlExample sumBorrowuuid() {
        this.sumCol="BORROWUUID";
        return this;
    }

    public GoodsBorrowDtlExample sumBorrowpayuuid() {
        this.sumCol="BORROWPAYUUID";
        return this;
    }

    public GoodsBorrowDtlExample sumBackpayuuid() {
        this.sumCol="BACKPAYUUID";
        return this;
    }

    public GoodsBorrowDtlExample sumCompensatepayuuid() {
        this.sumCol="COMPENSATEPAYUUID";
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

    public GoodsBorrowDtlExample page(int offset, int limit) {
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

        public Criteria andGoodsuuidIsNull() {
            addCriterion("GOODSUUID is null");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidIsNotNull() {
            addCriterion("GOODSUUID is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidEqualTo(String value) {
            addCriterion("GOODSUUID =", value, "goodsuuid");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidNotEqualTo(String value) {
            addCriterion("GOODSUUID <>", value, "goodsuuid");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidGreaterThan(String value) {
            addCriterion("GOODSUUID >", value, "goodsuuid");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidGreaterThanOrEqualTo(String value) {
            addCriterion("GOODSUUID >=", value, "goodsuuid");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidLessThan(String value) {
            addCriterion("GOODSUUID <", value, "goodsuuid");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidLessThanOrEqualTo(String value) {
            addCriterion("GOODSUUID <=", value, "goodsuuid");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidLike(String value) {
            addCriterion("GOODSUUID like", value, "goodsuuid");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidNotLike(String value) {
            addCriterion("GOODSUUID not like", value, "goodsuuid");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidIn(List<String> values) {
            addCriterion("GOODSUUID in", values, "goodsuuid");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidNotIn(List<String> values) {
            addCriterion("GOODSUUID not in", values, "goodsuuid");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidBetween(String value1, String value2) {
            addCriterion("GOODSUUID between", value1, value2, "goodsuuid");
            return (Criteria) this;
        }

        public Criteria andGoodsuuidNotBetween(String value1, String value2) {
            addCriterion("GOODSUUID not between", value1, value2, "goodsuuid");
            return (Criteria) this;
        }

        public Criteria andGoodscodeIsNull() {
            addCriterion("GOODSCODE is null");
            return (Criteria) this;
        }

        public Criteria andGoodscodeIsNotNull() {
            addCriterion("GOODSCODE is not null");
            return (Criteria) this;
        }

        public Criteria andGoodscodeEqualTo(String value) {
            addCriterion("GOODSCODE =", value, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodscodeNotEqualTo(String value) {
            addCriterion("GOODSCODE <>", value, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodscodeGreaterThan(String value) {
            addCriterion("GOODSCODE >", value, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodscodeGreaterThanOrEqualTo(String value) {
            addCriterion("GOODSCODE >=", value, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodscodeLessThan(String value) {
            addCriterion("GOODSCODE <", value, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodscodeLessThanOrEqualTo(String value) {
            addCriterion("GOODSCODE <=", value, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodscodeLike(String value) {
            addCriterion("GOODSCODE like", value, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodscodeNotLike(String value) {
            addCriterion("GOODSCODE not like", value, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodscodeIn(List<String> values) {
            addCriterion("GOODSCODE in", values, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodscodeNotIn(List<String> values) {
            addCriterion("GOODSCODE not in", values, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodscodeBetween(String value1, String value2) {
            addCriterion("GOODSCODE between", value1, value2, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodscodeNotBetween(String value1, String value2) {
            addCriterion("GOODSCODE not between", value1, value2, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIsNull() {
            addCriterion("GOODSNAME is null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIsNotNull() {
            addCriterion("GOODSNAME is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameEqualTo(String value) {
            addCriterion("GOODSNAME =", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotEqualTo(String value) {
            addCriterion("GOODSNAME <>", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThan(String value) {
            addCriterion("GOODSNAME >", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThanOrEqualTo(String value) {
            addCriterion("GOODSNAME >=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThan(String value) {
            addCriterion("GOODSNAME <", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThanOrEqualTo(String value) {
            addCriterion("GOODSNAME <=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLike(String value) {
            addCriterion("GOODSNAME like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotLike(String value) {
            addCriterion("GOODSNAME not like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIn(List<String> values) {
            addCriterion("GOODSNAME in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotIn(List<String> values) {
            addCriterion("GOODSNAME not in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameBetween(String value1, String value2) {
            addCriterion("GOODSNAME between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotBetween(String value1, String value2) {
            addCriterion("GOODSNAME not between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andBorrowqtyIsNull() {
            addCriterion("BORROWQTY is null");
            return (Criteria) this;
        }

        public Criteria andBorrowqtyIsNotNull() {
            addCriterion("BORROWQTY is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowqtyEqualTo(BigDecimal value) {
            addCriterion("BORROWQTY =", value, "borrowqty");
            return (Criteria) this;
        }

        public Criteria andBorrowqtyNotEqualTo(BigDecimal value) {
            addCriterion("BORROWQTY <>", value, "borrowqty");
            return (Criteria) this;
        }

        public Criteria andBorrowqtyGreaterThan(BigDecimal value) {
            addCriterion("BORROWQTY >", value, "borrowqty");
            return (Criteria) this;
        }

        public Criteria andBorrowqtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BORROWQTY >=", value, "borrowqty");
            return (Criteria) this;
        }

        public Criteria andBorrowqtyLessThan(BigDecimal value) {
            addCriterion("BORROWQTY <", value, "borrowqty");
            return (Criteria) this;
        }

        public Criteria andBorrowqtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BORROWQTY <=", value, "borrowqty");
            return (Criteria) this;
        }

        public Criteria andBorrowqtyIn(List<BigDecimal> values) {
            addCriterion("BORROWQTY in", values, "borrowqty");
            return (Criteria) this;
        }

        public Criteria andBorrowqtyNotIn(List<BigDecimal> values) {
            addCriterion("BORROWQTY not in", values, "borrowqty");
            return (Criteria) this;
        }

        public Criteria andBorrowqtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BORROWQTY between", value1, value2, "borrowqty");
            return (Criteria) this;
        }

        public Criteria andBorrowqtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BORROWQTY not between", value1, value2, "borrowqty");
            return (Criteria) this;
        }

        public Criteria andBorrowdescripIsNull() {
            addCriterion("BORROWDESCRIP is null");
            return (Criteria) this;
        }

        public Criteria andBorrowdescripIsNotNull() {
            addCriterion("BORROWDESCRIP is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowdescripEqualTo(String value) {
            addCriterion("BORROWDESCRIP =", value, "borrowdescrip");
            return (Criteria) this;
        }

        public Criteria andBorrowdescripNotEqualTo(String value) {
            addCriterion("BORROWDESCRIP <>", value, "borrowdescrip");
            return (Criteria) this;
        }

        public Criteria andBorrowdescripGreaterThan(String value) {
            addCriterion("BORROWDESCRIP >", value, "borrowdescrip");
            return (Criteria) this;
        }

        public Criteria andBorrowdescripGreaterThanOrEqualTo(String value) {
            addCriterion("BORROWDESCRIP >=", value, "borrowdescrip");
            return (Criteria) this;
        }

        public Criteria andBorrowdescripLessThan(String value) {
            addCriterion("BORROWDESCRIP <", value, "borrowdescrip");
            return (Criteria) this;
        }

        public Criteria andBorrowdescripLessThanOrEqualTo(String value) {
            addCriterion("BORROWDESCRIP <=", value, "borrowdescrip");
            return (Criteria) this;
        }

        public Criteria andBorrowdescripLike(String value) {
            addCriterion("BORROWDESCRIP like", value, "borrowdescrip");
            return (Criteria) this;
        }

        public Criteria andBorrowdescripNotLike(String value) {
            addCriterion("BORROWDESCRIP not like", value, "borrowdescrip");
            return (Criteria) this;
        }

        public Criteria andBorrowdescripIn(List<String> values) {
            addCriterion("BORROWDESCRIP in", values, "borrowdescrip");
            return (Criteria) this;
        }

        public Criteria andBorrowdescripNotIn(List<String> values) {
            addCriterion("BORROWDESCRIP not in", values, "borrowdescrip");
            return (Criteria) this;
        }

        public Criteria andBorrowdescripBetween(String value1, String value2) {
            addCriterion("BORROWDESCRIP between", value1, value2, "borrowdescrip");
            return (Criteria) this;
        }

        public Criteria andBorrowdescripNotBetween(String value1, String value2) {
            addCriterion("BORROWDESCRIP not between", value1, value2, "borrowdescrip");
            return (Criteria) this;
        }

        public Criteria andDepositamtIsNull() {
            addCriterion("DEPOSITAMT is null");
            return (Criteria) this;
        }

        public Criteria andDepositamtIsNotNull() {
            addCriterion("DEPOSITAMT is not null");
            return (Criteria) this;
        }

        public Criteria andDepositamtEqualTo(BigDecimal value) {
            addCriterion("DEPOSITAMT =", value, "depositamt");
            return (Criteria) this;
        }

        public Criteria andDepositamtNotEqualTo(BigDecimal value) {
            addCriterion("DEPOSITAMT <>", value, "depositamt");
            return (Criteria) this;
        }

        public Criteria andDepositamtGreaterThan(BigDecimal value) {
            addCriterion("DEPOSITAMT >", value, "depositamt");
            return (Criteria) this;
        }

        public Criteria andDepositamtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DEPOSITAMT >=", value, "depositamt");
            return (Criteria) this;
        }

        public Criteria andDepositamtLessThan(BigDecimal value) {
            addCriterion("DEPOSITAMT <", value, "depositamt");
            return (Criteria) this;
        }

        public Criteria andDepositamtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DEPOSITAMT <=", value, "depositamt");
            return (Criteria) this;
        }

        public Criteria andDepositamtIn(List<BigDecimal> values) {
            addCriterion("DEPOSITAMT in", values, "depositamt");
            return (Criteria) this;
        }

        public Criteria andDepositamtNotIn(List<BigDecimal> values) {
            addCriterion("DEPOSITAMT not in", values, "depositamt");
            return (Criteria) this;
        }

        public Criteria andDepositamtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEPOSITAMT between", value1, value2, "depositamt");
            return (Criteria) this;
        }

        public Criteria andDepositamtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEPOSITAMT not between", value1, value2, "depositamt");
            return (Criteria) this;
        }

        public Criteria andDamagedIsNull() {
            addCriterion("DAMAGED is null");
            return (Criteria) this;
        }

        public Criteria andDamagedIsNotNull() {
            addCriterion("DAMAGED is not null");
            return (Criteria) this;
        }

        public Criteria andDamagedEqualTo(Integer value) {
            addCriterion("DAMAGED =", value, "damaged");
            return (Criteria) this;
        }

        public Criteria andDamagedNotEqualTo(Integer value) {
            addCriterion("DAMAGED <>", value, "damaged");
            return (Criteria) this;
        }

        public Criteria andDamagedGreaterThan(Integer value) {
            addCriterion("DAMAGED >", value, "damaged");
            return (Criteria) this;
        }

        public Criteria andDamagedGreaterThanOrEqualTo(Integer value) {
            addCriterion("DAMAGED >=", value, "damaged");
            return (Criteria) this;
        }

        public Criteria andDamagedLessThan(Integer value) {
            addCriterion("DAMAGED <", value, "damaged");
            return (Criteria) this;
        }

        public Criteria andDamagedLessThanOrEqualTo(Integer value) {
            addCriterion("DAMAGED <=", value, "damaged");
            return (Criteria) this;
        }

        public Criteria andDamagedIn(List<Integer> values) {
            addCriterion("DAMAGED in", values, "damaged");
            return (Criteria) this;
        }

        public Criteria andDamagedNotIn(List<Integer> values) {
            addCriterion("DAMAGED not in", values, "damaged");
            return (Criteria) this;
        }

        public Criteria andDamagedBetween(Integer value1, Integer value2) {
            addCriterion("DAMAGED between", value1, value2, "damaged");
            return (Criteria) this;
        }

        public Criteria andDamagedNotBetween(Integer value1, Integer value2) {
            addCriterion("DAMAGED not between", value1, value2, "damaged");
            return (Criteria) this;
        }

        public Criteria andReturndescripIsNull() {
            addCriterion("RETURNDESCRIP is null");
            return (Criteria) this;
        }

        public Criteria andReturndescripIsNotNull() {
            addCriterion("RETURNDESCRIP is not null");
            return (Criteria) this;
        }

        public Criteria andReturndescripEqualTo(String value) {
            addCriterion("RETURNDESCRIP =", value, "returndescrip");
            return (Criteria) this;
        }

        public Criteria andReturndescripNotEqualTo(String value) {
            addCriterion("RETURNDESCRIP <>", value, "returndescrip");
            return (Criteria) this;
        }

        public Criteria andReturndescripGreaterThan(String value) {
            addCriterion("RETURNDESCRIP >", value, "returndescrip");
            return (Criteria) this;
        }

        public Criteria andReturndescripGreaterThanOrEqualTo(String value) {
            addCriterion("RETURNDESCRIP >=", value, "returndescrip");
            return (Criteria) this;
        }

        public Criteria andReturndescripLessThan(String value) {
            addCriterion("RETURNDESCRIP <", value, "returndescrip");
            return (Criteria) this;
        }

        public Criteria andReturndescripLessThanOrEqualTo(String value) {
            addCriterion("RETURNDESCRIP <=", value, "returndescrip");
            return (Criteria) this;
        }

        public Criteria andReturndescripLike(String value) {
            addCriterion("RETURNDESCRIP like", value, "returndescrip");
            return (Criteria) this;
        }

        public Criteria andReturndescripNotLike(String value) {
            addCriterion("RETURNDESCRIP not like", value, "returndescrip");
            return (Criteria) this;
        }

        public Criteria andReturndescripIn(List<String> values) {
            addCriterion("RETURNDESCRIP in", values, "returndescrip");
            return (Criteria) this;
        }

        public Criteria andReturndescripNotIn(List<String> values) {
            addCriterion("RETURNDESCRIP not in", values, "returndescrip");
            return (Criteria) this;
        }

        public Criteria andReturndescripBetween(String value1, String value2) {
            addCriterion("RETURNDESCRIP between", value1, value2, "returndescrip");
            return (Criteria) this;
        }

        public Criteria andReturndescripNotBetween(String value1, String value2) {
            addCriterion("RETURNDESCRIP not between", value1, value2, "returndescrip");
            return (Criteria) this;
        }

        public Criteria andBackqtyIsNull() {
            addCriterion("BACKQTY is null");
            return (Criteria) this;
        }

        public Criteria andBackqtyIsNotNull() {
            addCriterion("BACKQTY is not null");
            return (Criteria) this;
        }

        public Criteria andBackqtyEqualTo(BigDecimal value) {
            addCriterion("BACKQTY =", value, "backqty");
            return (Criteria) this;
        }

        public Criteria andBackqtyNotEqualTo(BigDecimal value) {
            addCriterion("BACKQTY <>", value, "backqty");
            return (Criteria) this;
        }

        public Criteria andBackqtyGreaterThan(BigDecimal value) {
            addCriterion("BACKQTY >", value, "backqty");
            return (Criteria) this;
        }

        public Criteria andBackqtyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BACKQTY >=", value, "backqty");
            return (Criteria) this;
        }

        public Criteria andBackqtyLessThan(BigDecimal value) {
            addCriterion("BACKQTY <", value, "backqty");
            return (Criteria) this;
        }

        public Criteria andBackqtyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BACKQTY <=", value, "backqty");
            return (Criteria) this;
        }

        public Criteria andBackqtyIn(List<BigDecimal> values) {
            addCriterion("BACKQTY in", values, "backqty");
            return (Criteria) this;
        }

        public Criteria andBackqtyNotIn(List<BigDecimal> values) {
            addCriterion("BACKQTY not in", values, "backqty");
            return (Criteria) this;
        }

        public Criteria andBackqtyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BACKQTY between", value1, value2, "backqty");
            return (Criteria) this;
        }

        public Criteria andBackqtyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BACKQTY not between", value1, value2, "backqty");
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

        public Criteria andBackdepositamtIsNull() {
            addCriterion("BACKDEPOSITAMT is null");
            return (Criteria) this;
        }

        public Criteria andBackdepositamtIsNotNull() {
            addCriterion("BACKDEPOSITAMT is not null");
            return (Criteria) this;
        }

        public Criteria andBackdepositamtEqualTo(BigDecimal value) {
            addCriterion("BACKDEPOSITAMT =", value, "backdepositamt");
            return (Criteria) this;
        }

        public Criteria andBackdepositamtNotEqualTo(BigDecimal value) {
            addCriterion("BACKDEPOSITAMT <>", value, "backdepositamt");
            return (Criteria) this;
        }

        public Criteria andBackdepositamtGreaterThan(BigDecimal value) {
            addCriterion("BACKDEPOSITAMT >", value, "backdepositamt");
            return (Criteria) this;
        }

        public Criteria andBackdepositamtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BACKDEPOSITAMT >=", value, "backdepositamt");
            return (Criteria) this;
        }

        public Criteria andBackdepositamtLessThan(BigDecimal value) {
            addCriterion("BACKDEPOSITAMT <", value, "backdepositamt");
            return (Criteria) this;
        }

        public Criteria andBackdepositamtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BACKDEPOSITAMT <=", value, "backdepositamt");
            return (Criteria) this;
        }

        public Criteria andBackdepositamtIn(List<BigDecimal> values) {
            addCriterion("BACKDEPOSITAMT in", values, "backdepositamt");
            return (Criteria) this;
        }

        public Criteria andBackdepositamtNotIn(List<BigDecimal> values) {
            addCriterion("BACKDEPOSITAMT not in", values, "backdepositamt");
            return (Criteria) this;
        }

        public Criteria andBackdepositamtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BACKDEPOSITAMT between", value1, value2, "backdepositamt");
            return (Criteria) this;
        }

        public Criteria andBackdepositamtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BACKDEPOSITAMT not between", value1, value2, "backdepositamt");
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

        public Criteria andBorrowuuidIsNull() {
            addCriterion("BORROWUUID is null");
            return (Criteria) this;
        }

        public Criteria andBorrowuuidIsNotNull() {
            addCriterion("BORROWUUID is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowuuidEqualTo(String value) {
            addCriterion("BORROWUUID =", value, "borrowuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowuuidNotEqualTo(String value) {
            addCriterion("BORROWUUID <>", value, "borrowuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowuuidGreaterThan(String value) {
            addCriterion("BORROWUUID >", value, "borrowuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowuuidGreaterThanOrEqualTo(String value) {
            addCriterion("BORROWUUID >=", value, "borrowuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowuuidLessThan(String value) {
            addCriterion("BORROWUUID <", value, "borrowuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowuuidLessThanOrEqualTo(String value) {
            addCriterion("BORROWUUID <=", value, "borrowuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowuuidLike(String value) {
            addCriterion("BORROWUUID like", value, "borrowuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowuuidNotLike(String value) {
            addCriterion("BORROWUUID not like", value, "borrowuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowuuidIn(List<String> values) {
            addCriterion("BORROWUUID in", values, "borrowuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowuuidNotIn(List<String> values) {
            addCriterion("BORROWUUID not in", values, "borrowuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowuuidBetween(String value1, String value2) {
            addCriterion("BORROWUUID between", value1, value2, "borrowuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowuuidNotBetween(String value1, String value2) {
            addCriterion("BORROWUUID not between", value1, value2, "borrowuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowpayuuidIsNull() {
            addCriterion("BORROWPAYUUID is null");
            return (Criteria) this;
        }

        public Criteria andBorrowpayuuidIsNotNull() {
            addCriterion("BORROWPAYUUID is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowpayuuidEqualTo(String value) {
            addCriterion("BORROWPAYUUID =", value, "borrowpayuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowpayuuidNotEqualTo(String value) {
            addCriterion("BORROWPAYUUID <>", value, "borrowpayuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowpayuuidGreaterThan(String value) {
            addCriterion("BORROWPAYUUID >", value, "borrowpayuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowpayuuidGreaterThanOrEqualTo(String value) {
            addCriterion("BORROWPAYUUID >=", value, "borrowpayuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowpayuuidLessThan(String value) {
            addCriterion("BORROWPAYUUID <", value, "borrowpayuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowpayuuidLessThanOrEqualTo(String value) {
            addCriterion("BORROWPAYUUID <=", value, "borrowpayuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowpayuuidLike(String value) {
            addCriterion("BORROWPAYUUID like", value, "borrowpayuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowpayuuidNotLike(String value) {
            addCriterion("BORROWPAYUUID not like", value, "borrowpayuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowpayuuidIn(List<String> values) {
            addCriterion("BORROWPAYUUID in", values, "borrowpayuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowpayuuidNotIn(List<String> values) {
            addCriterion("BORROWPAYUUID not in", values, "borrowpayuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowpayuuidBetween(String value1, String value2) {
            addCriterion("BORROWPAYUUID between", value1, value2, "borrowpayuuid");
            return (Criteria) this;
        }

        public Criteria andBorrowpayuuidNotBetween(String value1, String value2) {
            addCriterion("BORROWPAYUUID not between", value1, value2, "borrowpayuuid");
            return (Criteria) this;
        }

        public Criteria andBackpayuuidIsNull() {
            addCriterion("BACKPAYUUID is null");
            return (Criteria) this;
        }

        public Criteria andBackpayuuidIsNotNull() {
            addCriterion("BACKPAYUUID is not null");
            return (Criteria) this;
        }

        public Criteria andBackpayuuidEqualTo(String value) {
            addCriterion("BACKPAYUUID =", value, "backpayuuid");
            return (Criteria) this;
        }

        public Criteria andBackpayuuidNotEqualTo(String value) {
            addCriterion("BACKPAYUUID <>", value, "backpayuuid");
            return (Criteria) this;
        }

        public Criteria andBackpayuuidGreaterThan(String value) {
            addCriterion("BACKPAYUUID >", value, "backpayuuid");
            return (Criteria) this;
        }

        public Criteria andBackpayuuidGreaterThanOrEqualTo(String value) {
            addCriterion("BACKPAYUUID >=", value, "backpayuuid");
            return (Criteria) this;
        }

        public Criteria andBackpayuuidLessThan(String value) {
            addCriterion("BACKPAYUUID <", value, "backpayuuid");
            return (Criteria) this;
        }

        public Criteria andBackpayuuidLessThanOrEqualTo(String value) {
            addCriterion("BACKPAYUUID <=", value, "backpayuuid");
            return (Criteria) this;
        }

        public Criteria andBackpayuuidLike(String value) {
            addCriterion("BACKPAYUUID like", value, "backpayuuid");
            return (Criteria) this;
        }

        public Criteria andBackpayuuidNotLike(String value) {
            addCriterion("BACKPAYUUID not like", value, "backpayuuid");
            return (Criteria) this;
        }

        public Criteria andBackpayuuidIn(List<String> values) {
            addCriterion("BACKPAYUUID in", values, "backpayuuid");
            return (Criteria) this;
        }

        public Criteria andBackpayuuidNotIn(List<String> values) {
            addCriterion("BACKPAYUUID not in", values, "backpayuuid");
            return (Criteria) this;
        }

        public Criteria andBackpayuuidBetween(String value1, String value2) {
            addCriterion("BACKPAYUUID between", value1, value2, "backpayuuid");
            return (Criteria) this;
        }

        public Criteria andBackpayuuidNotBetween(String value1, String value2) {
            addCriterion("BACKPAYUUID not between", value1, value2, "backpayuuid");
            return (Criteria) this;
        }

        public Criteria andCompensatepayuuidIsNull() {
            addCriterion("COMPENSATEPAYUUID is null");
            return (Criteria) this;
        }

        public Criteria andCompensatepayuuidIsNotNull() {
            addCriterion("COMPENSATEPAYUUID is not null");
            return (Criteria) this;
        }

        public Criteria andCompensatepayuuidEqualTo(String value) {
            addCriterion("COMPENSATEPAYUUID =", value, "compensatepayuuid");
            return (Criteria) this;
        }

        public Criteria andCompensatepayuuidNotEqualTo(String value) {
            addCriterion("COMPENSATEPAYUUID <>", value, "compensatepayuuid");
            return (Criteria) this;
        }

        public Criteria andCompensatepayuuidGreaterThan(String value) {
            addCriterion("COMPENSATEPAYUUID >", value, "compensatepayuuid");
            return (Criteria) this;
        }

        public Criteria andCompensatepayuuidGreaterThanOrEqualTo(String value) {
            addCriterion("COMPENSATEPAYUUID >=", value, "compensatepayuuid");
            return (Criteria) this;
        }

        public Criteria andCompensatepayuuidLessThan(String value) {
            addCriterion("COMPENSATEPAYUUID <", value, "compensatepayuuid");
            return (Criteria) this;
        }

        public Criteria andCompensatepayuuidLessThanOrEqualTo(String value) {
            addCriterion("COMPENSATEPAYUUID <=", value, "compensatepayuuid");
            return (Criteria) this;
        }

        public Criteria andCompensatepayuuidLike(String value) {
            addCriterion("COMPENSATEPAYUUID like", value, "compensatepayuuid");
            return (Criteria) this;
        }

        public Criteria andCompensatepayuuidNotLike(String value) {
            addCriterion("COMPENSATEPAYUUID not like", value, "compensatepayuuid");
            return (Criteria) this;
        }

        public Criteria andCompensatepayuuidIn(List<String> values) {
            addCriterion("COMPENSATEPAYUUID in", values, "compensatepayuuid");
            return (Criteria) this;
        }

        public Criteria andCompensatepayuuidNotIn(List<String> values) {
            addCriterion("COMPENSATEPAYUUID not in", values, "compensatepayuuid");
            return (Criteria) this;
        }

        public Criteria andCompensatepayuuidBetween(String value1, String value2) {
            addCriterion("COMPENSATEPAYUUID between", value1, value2, "compensatepayuuid");
            return (Criteria) this;
        }

        public Criteria andCompensatepayuuidNotBetween(String value1, String value2) {
            addCriterion("COMPENSATEPAYUUID not between", value1, value2, "compensatepayuuid");
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