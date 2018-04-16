package com.sharing.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsBorrowMstExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private String sumCol;

    private Integer offset;

    private Integer limit;

    public GoodsBorrowMstExample() {
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

    public GoodsBorrowMstExample sumUuid() {
        this.sumCol="UUID";
        return this;
    }

    public GoodsBorrowMstExample sumBillnumber() {
        this.sumCol="BILLNUMBER";
        return this;
    }

    public GoodsBorrowMstExample sumStat() {
        this.sumCol="STAT";
        return this;
    }

    public GoodsBorrowMstExample sumBorrowertype() {
        this.sumCol="BORROWERTYPE";
        return this;
    }

    public GoodsBorrowMstExample sumBorrower() {
        this.sumCol="BORROWER";
        return this;
    }

    public GoodsBorrowMstExample sumMobile() {
        this.sumCol="MOBILE";
        return this;
    }

    public GoodsBorrowMstExample sumAddress() {
        this.sumCol="ADDRESS";
        return this;
    }

    public GoodsBorrowMstExample sumReturntime() {
        this.sumCol="RETURNTIME";
        return this;
    }

    public GoodsBorrowMstExample sumRealreturntime() {
        this.sumCol="REALRETURNTIME";
        return this;
    }

    public GoodsBorrowMstExample sumFiller() {
        this.sumCol="FILLER";
        return this;
    }

    public GoodsBorrowMstExample sumFildate() {
        this.sumCol="FILDATE";
        return this;
    }

    public GoodsBorrowMstExample sumLaster() {
        this.sumCol="LASTER";
        return this;
    }

    public GoodsBorrowMstExample sumLastupdtime() {
        this.sumCol="LASTUPDTIME";
        return this;
    }

    public GoodsBorrowMstExample sumMemo() {
        this.sumCol="MEMO";
        return this;
    }

    public GoodsBorrowMstExample sumStoreuuid() {
        this.sumCol="STOREUUID";
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

    public GoodsBorrowMstExample page(int offset, int limit) {
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

        public Criteria andBillnumberIsNull() {
            addCriterion("BILLNUMBER is null");
            return (Criteria) this;
        }

        public Criteria andBillnumberIsNotNull() {
            addCriterion("BILLNUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andBillnumberEqualTo(String value) {
            addCriterion("BILLNUMBER =", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberNotEqualTo(String value) {
            addCriterion("BILLNUMBER <>", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberGreaterThan(String value) {
            addCriterion("BILLNUMBER >", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberGreaterThanOrEqualTo(String value) {
            addCriterion("BILLNUMBER >=", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberLessThan(String value) {
            addCriterion("BILLNUMBER <", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberLessThanOrEqualTo(String value) {
            addCriterion("BILLNUMBER <=", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberLike(String value) {
            addCriterion("BILLNUMBER like", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberNotLike(String value) {
            addCriterion("BILLNUMBER not like", value, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberIn(List<String> values) {
            addCriterion("BILLNUMBER in", values, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberNotIn(List<String> values) {
            addCriterion("BILLNUMBER not in", values, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberBetween(String value1, String value2) {
            addCriterion("BILLNUMBER between", value1, value2, "billnumber");
            return (Criteria) this;
        }

        public Criteria andBillnumberNotBetween(String value1, String value2) {
            addCriterion("BILLNUMBER not between", value1, value2, "billnumber");
            return (Criteria) this;
        }

        public Criteria andStatIsNull() {
            addCriterion("STAT is null");
            return (Criteria) this;
        }

        public Criteria andStatIsNotNull() {
            addCriterion("STAT is not null");
            return (Criteria) this;
        }

        public Criteria andStatEqualTo(String value) {
            addCriterion("STAT =", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotEqualTo(String value) {
            addCriterion("STAT <>", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThan(String value) {
            addCriterion("STAT >", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThanOrEqualTo(String value) {
            addCriterion("STAT >=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThan(String value) {
            addCriterion("STAT <", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThanOrEqualTo(String value) {
            addCriterion("STAT <=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLike(String value) {
            addCriterion("STAT like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotLike(String value) {
            addCriterion("STAT not like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatIn(List<String> values) {
            addCriterion("STAT in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotIn(List<String> values) {
            addCriterion("STAT not in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatBetween(String value1, String value2) {
            addCriterion("STAT between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotBetween(String value1, String value2) {
            addCriterion("STAT not between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andBorrowertypeIsNull() {
            addCriterion("BORROWERTYPE is null");
            return (Criteria) this;
        }

        public Criteria andBorrowertypeIsNotNull() {
            addCriterion("BORROWERTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowertypeEqualTo(String value) {
            addCriterion("BORROWERTYPE =", value, "borrowertype");
            return (Criteria) this;
        }

        public Criteria andBorrowertypeNotEqualTo(String value) {
            addCriterion("BORROWERTYPE <>", value, "borrowertype");
            return (Criteria) this;
        }

        public Criteria andBorrowertypeGreaterThan(String value) {
            addCriterion("BORROWERTYPE >", value, "borrowertype");
            return (Criteria) this;
        }

        public Criteria andBorrowertypeGreaterThanOrEqualTo(String value) {
            addCriterion("BORROWERTYPE >=", value, "borrowertype");
            return (Criteria) this;
        }

        public Criteria andBorrowertypeLessThan(String value) {
            addCriterion("BORROWERTYPE <", value, "borrowertype");
            return (Criteria) this;
        }

        public Criteria andBorrowertypeLessThanOrEqualTo(String value) {
            addCriterion("BORROWERTYPE <=", value, "borrowertype");
            return (Criteria) this;
        }

        public Criteria andBorrowertypeLike(String value) {
            addCriterion("BORROWERTYPE like", value, "borrowertype");
            return (Criteria) this;
        }

        public Criteria andBorrowertypeNotLike(String value) {
            addCriterion("BORROWERTYPE not like", value, "borrowertype");
            return (Criteria) this;
        }

        public Criteria andBorrowertypeIn(List<String> values) {
            addCriterion("BORROWERTYPE in", values, "borrowertype");
            return (Criteria) this;
        }

        public Criteria andBorrowertypeNotIn(List<String> values) {
            addCriterion("BORROWERTYPE not in", values, "borrowertype");
            return (Criteria) this;
        }

        public Criteria andBorrowertypeBetween(String value1, String value2) {
            addCriterion("BORROWERTYPE between", value1, value2, "borrowertype");
            return (Criteria) this;
        }

        public Criteria andBorrowertypeNotBetween(String value1, String value2) {
            addCriterion("BORROWERTYPE not between", value1, value2, "borrowertype");
            return (Criteria) this;
        }

        public Criteria andBorrowerIsNull() {
            addCriterion("BORROWER is null");
            return (Criteria) this;
        }

        public Criteria andBorrowerIsNotNull() {
            addCriterion("BORROWER is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowerEqualTo(String value) {
            addCriterion("BORROWER =", value, "borrower");
            return (Criteria) this;
        }

        public Criteria andBorrowerNotEqualTo(String value) {
            addCriterion("BORROWER <>", value, "borrower");
            return (Criteria) this;
        }

        public Criteria andBorrowerGreaterThan(String value) {
            addCriterion("BORROWER >", value, "borrower");
            return (Criteria) this;
        }

        public Criteria andBorrowerGreaterThanOrEqualTo(String value) {
            addCriterion("BORROWER >=", value, "borrower");
            return (Criteria) this;
        }

        public Criteria andBorrowerLessThan(String value) {
            addCriterion("BORROWER <", value, "borrower");
            return (Criteria) this;
        }

        public Criteria andBorrowerLessThanOrEqualTo(String value) {
            addCriterion("BORROWER <=", value, "borrower");
            return (Criteria) this;
        }

        public Criteria andBorrowerLike(String value) {
            addCriterion("BORROWER like", value, "borrower");
            return (Criteria) this;
        }

        public Criteria andBorrowerNotLike(String value) {
            addCriterion("BORROWER not like", value, "borrower");
            return (Criteria) this;
        }

        public Criteria andBorrowerIn(List<String> values) {
            addCriterion("BORROWER in", values, "borrower");
            return (Criteria) this;
        }

        public Criteria andBorrowerNotIn(List<String> values) {
            addCriterion("BORROWER not in", values, "borrower");
            return (Criteria) this;
        }

        public Criteria andBorrowerBetween(String value1, String value2) {
            addCriterion("BORROWER between", value1, value2, "borrower");
            return (Criteria) this;
        }

        public Criteria andBorrowerNotBetween(String value1, String value2) {
            addCriterion("BORROWER not between", value1, value2, "borrower");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("MOBILE =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("MOBILE <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("MOBILE >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("MOBILE <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("MOBILE <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("MOBILE like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("MOBILE not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("MOBILE in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("MOBILE not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("MOBILE between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("MOBILE not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andReturntimeIsNull() {
            addCriterion("RETURNTIME is null");
            return (Criteria) this;
        }

        public Criteria andReturntimeIsNotNull() {
            addCriterion("RETURNTIME is not null");
            return (Criteria) this;
        }

        public Criteria andReturntimeEqualTo(Date value) {
            addCriterion("RETURNTIME =", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeNotEqualTo(Date value) {
            addCriterion("RETURNTIME <>", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeGreaterThan(Date value) {
            addCriterion("RETURNTIME >", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RETURNTIME >=", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeLessThan(Date value) {
            addCriterion("RETURNTIME <", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeLessThanOrEqualTo(Date value) {
            addCriterion("RETURNTIME <=", value, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeIn(List<Date> values) {
            addCriterion("RETURNTIME in", values, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeNotIn(List<Date> values) {
            addCriterion("RETURNTIME not in", values, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeBetween(Date value1, Date value2) {
            addCriterion("RETURNTIME between", value1, value2, "returntime");
            return (Criteria) this;
        }

        public Criteria andReturntimeNotBetween(Date value1, Date value2) {
            addCriterion("RETURNTIME not between", value1, value2, "returntime");
            return (Criteria) this;
        }

        public Criteria andRealreturntimeIsNull() {
            addCriterion("REALRETURNTIME is null");
            return (Criteria) this;
        }

        public Criteria andRealreturntimeIsNotNull() {
            addCriterion("REALRETURNTIME is not null");
            return (Criteria) this;
        }

        public Criteria andRealreturntimeEqualTo(Date value) {
            addCriterion("REALRETURNTIME =", value, "realreturntime");
            return (Criteria) this;
        }

        public Criteria andRealreturntimeNotEqualTo(Date value) {
            addCriterion("REALRETURNTIME <>", value, "realreturntime");
            return (Criteria) this;
        }

        public Criteria andRealreturntimeGreaterThan(Date value) {
            addCriterion("REALRETURNTIME >", value, "realreturntime");
            return (Criteria) this;
        }

        public Criteria andRealreturntimeGreaterThanOrEqualTo(Date value) {
            addCriterion("REALRETURNTIME >=", value, "realreturntime");
            return (Criteria) this;
        }

        public Criteria andRealreturntimeLessThan(Date value) {
            addCriterion("REALRETURNTIME <", value, "realreturntime");
            return (Criteria) this;
        }

        public Criteria andRealreturntimeLessThanOrEqualTo(Date value) {
            addCriterion("REALRETURNTIME <=", value, "realreturntime");
            return (Criteria) this;
        }

        public Criteria andRealreturntimeIn(List<Date> values) {
            addCriterion("REALRETURNTIME in", values, "realreturntime");
            return (Criteria) this;
        }

        public Criteria andRealreturntimeNotIn(List<Date> values) {
            addCriterion("REALRETURNTIME not in", values, "realreturntime");
            return (Criteria) this;
        }

        public Criteria andRealreturntimeBetween(Date value1, Date value2) {
            addCriterion("REALRETURNTIME between", value1, value2, "realreturntime");
            return (Criteria) this;
        }

        public Criteria andRealreturntimeNotBetween(Date value1, Date value2) {
            addCriterion("REALRETURNTIME not between", value1, value2, "realreturntime");
            return (Criteria) this;
        }

        public Criteria andFillerIsNull() {
            addCriterion("FILLER is null");
            return (Criteria) this;
        }

        public Criteria andFillerIsNotNull() {
            addCriterion("FILLER is not null");
            return (Criteria) this;
        }

        public Criteria andFillerEqualTo(String value) {
            addCriterion("FILLER =", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotEqualTo(String value) {
            addCriterion("FILLER <>", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerGreaterThan(String value) {
            addCriterion("FILLER >", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerGreaterThanOrEqualTo(String value) {
            addCriterion("FILLER >=", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerLessThan(String value) {
            addCriterion("FILLER <", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerLessThanOrEqualTo(String value) {
            addCriterion("FILLER <=", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerLike(String value) {
            addCriterion("FILLER like", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotLike(String value) {
            addCriterion("FILLER not like", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerIn(List<String> values) {
            addCriterion("FILLER in", values, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotIn(List<String> values) {
            addCriterion("FILLER not in", values, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerBetween(String value1, String value2) {
            addCriterion("FILLER between", value1, value2, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotBetween(String value1, String value2) {
            addCriterion("FILLER not between", value1, value2, "filler");
            return (Criteria) this;
        }

        public Criteria andFildateIsNull() {
            addCriterion("FILDATE is null");
            return (Criteria) this;
        }

        public Criteria andFildateIsNotNull() {
            addCriterion("FILDATE is not null");
            return (Criteria) this;
        }

        public Criteria andFildateEqualTo(Date value) {
            addCriterion("FILDATE =", value, "fildate");
            return (Criteria) this;
        }

        public Criteria andFildateNotEqualTo(Date value) {
            addCriterion("FILDATE <>", value, "fildate");
            return (Criteria) this;
        }

        public Criteria andFildateGreaterThan(Date value) {
            addCriterion("FILDATE >", value, "fildate");
            return (Criteria) this;
        }

        public Criteria andFildateGreaterThanOrEqualTo(Date value) {
            addCriterion("FILDATE >=", value, "fildate");
            return (Criteria) this;
        }

        public Criteria andFildateLessThan(Date value) {
            addCriterion("FILDATE <", value, "fildate");
            return (Criteria) this;
        }

        public Criteria andFildateLessThanOrEqualTo(Date value) {
            addCriterion("FILDATE <=", value, "fildate");
            return (Criteria) this;
        }

        public Criteria andFildateIn(List<Date> values) {
            addCriterion("FILDATE in", values, "fildate");
            return (Criteria) this;
        }

        public Criteria andFildateNotIn(List<Date> values) {
            addCriterion("FILDATE not in", values, "fildate");
            return (Criteria) this;
        }

        public Criteria andFildateBetween(Date value1, Date value2) {
            addCriterion("FILDATE between", value1, value2, "fildate");
            return (Criteria) this;
        }

        public Criteria andFildateNotBetween(Date value1, Date value2) {
            addCriterion("FILDATE not between", value1, value2, "fildate");
            return (Criteria) this;
        }

        public Criteria andLasterIsNull() {
            addCriterion("LASTER is null");
            return (Criteria) this;
        }

        public Criteria andLasterIsNotNull() {
            addCriterion("LASTER is not null");
            return (Criteria) this;
        }

        public Criteria andLasterEqualTo(String value) {
            addCriterion("LASTER =", value, "laster");
            return (Criteria) this;
        }

        public Criteria andLasterNotEqualTo(String value) {
            addCriterion("LASTER <>", value, "laster");
            return (Criteria) this;
        }

        public Criteria andLasterGreaterThan(String value) {
            addCriterion("LASTER >", value, "laster");
            return (Criteria) this;
        }

        public Criteria andLasterGreaterThanOrEqualTo(String value) {
            addCriterion("LASTER >=", value, "laster");
            return (Criteria) this;
        }

        public Criteria andLasterLessThan(String value) {
            addCriterion("LASTER <", value, "laster");
            return (Criteria) this;
        }

        public Criteria andLasterLessThanOrEqualTo(String value) {
            addCriterion("LASTER <=", value, "laster");
            return (Criteria) this;
        }

        public Criteria andLasterLike(String value) {
            addCriterion("LASTER like", value, "laster");
            return (Criteria) this;
        }

        public Criteria andLasterNotLike(String value) {
            addCriterion("LASTER not like", value, "laster");
            return (Criteria) this;
        }

        public Criteria andLasterIn(List<String> values) {
            addCriterion("LASTER in", values, "laster");
            return (Criteria) this;
        }

        public Criteria andLasterNotIn(List<String> values) {
            addCriterion("LASTER not in", values, "laster");
            return (Criteria) this;
        }

        public Criteria andLasterBetween(String value1, String value2) {
            addCriterion("LASTER between", value1, value2, "laster");
            return (Criteria) this;
        }

        public Criteria andLasterNotBetween(String value1, String value2) {
            addCriterion("LASTER not between", value1, value2, "laster");
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

        public Criteria andStoreuuidIsNull() {
            addCriterion("STOREUUID is null");
            return (Criteria) this;
        }

        public Criteria andStoreuuidIsNotNull() {
            addCriterion("STOREUUID is not null");
            return (Criteria) this;
        }

        public Criteria andStoreuuidEqualTo(String value) {
            addCriterion("STOREUUID =", value, "storeuuid");
            return (Criteria) this;
        }

        public Criteria andStoreuuidNotEqualTo(String value) {
            addCriterion("STOREUUID <>", value, "storeuuid");
            return (Criteria) this;
        }

        public Criteria andStoreuuidGreaterThan(String value) {
            addCriterion("STOREUUID >", value, "storeuuid");
            return (Criteria) this;
        }

        public Criteria andStoreuuidGreaterThanOrEqualTo(String value) {
            addCriterion("STOREUUID >=", value, "storeuuid");
            return (Criteria) this;
        }

        public Criteria andStoreuuidLessThan(String value) {
            addCriterion("STOREUUID <", value, "storeuuid");
            return (Criteria) this;
        }

        public Criteria andStoreuuidLessThanOrEqualTo(String value) {
            addCriterion("STOREUUID <=", value, "storeuuid");
            return (Criteria) this;
        }

        public Criteria andStoreuuidLike(String value) {
            addCriterion("STOREUUID like", value, "storeuuid");
            return (Criteria) this;
        }

        public Criteria andStoreuuidNotLike(String value) {
            addCriterion("STOREUUID not like", value, "storeuuid");
            return (Criteria) this;
        }

        public Criteria andStoreuuidIn(List<String> values) {
            addCriterion("STOREUUID in", values, "storeuuid");
            return (Criteria) this;
        }

        public Criteria andStoreuuidNotIn(List<String> values) {
            addCriterion("STOREUUID not in", values, "storeuuid");
            return (Criteria) this;
        }

        public Criteria andStoreuuidBetween(String value1, String value2) {
            addCriterion("STOREUUID between", value1, value2, "storeuuid");
            return (Criteria) this;
        }

        public Criteria andStoreuuidNotBetween(String value1, String value2) {
            addCriterion("STOREUUID not between", value1, value2, "storeuuid");
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