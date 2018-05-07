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
        this.sumCol="uuid";
        return this;
    }

    public GoodsBorrowMstExample sumBillNumber() {
        this.sumCol="bill_number";
        return this;
    }

    public GoodsBorrowMstExample sumStat() {
        this.sumCol="stat";
        return this;
    }

    public GoodsBorrowMstExample sumBorrowType() {
        this.sumCol="borrow_type";
        return this;
    }

    public GoodsBorrowMstExample sumBorrower() {
        this.sumCol="borrower";
        return this;
    }

    public GoodsBorrowMstExample sumMobile() {
        this.sumCol="mobile";
        return this;
    }

    public GoodsBorrowMstExample sumAddress() {
        this.sumCol="address";
        return this;
    }

    public GoodsBorrowMstExample sumPlanReturnTime() {
        this.sumCol="plan_return_time";
        return this;
    }

    public GoodsBorrowMstExample sumRealReturnTime() {
        this.sumCol="real_return_time";
        return this;
    }

    public GoodsBorrowMstExample sumBorrowOperator() {
        this.sumCol="borrow_operator";
        return this;
    }

    public GoodsBorrowMstExample sumBorrowOperateTime() {
        this.sumCol="borrow_operate_time";
        return this;
    }

    public GoodsBorrowMstExample sumReturnOperator() {
        this.sumCol="return_operator";
        return this;
    }

    public GoodsBorrowMstExample sumReturnOperateTime() {
        this.sumCol="return_operate_time";
        return this;
    }

    public GoodsBorrowMstExample sumCreateTime() {
        this.sumCol="create_time";
        return this;
    }

    public GoodsBorrowMstExample sumLstUpdTime() {
        this.sumCol="lst_upd_time";
        return this;
    }

    public GoodsBorrowMstExample sumMemo() {
        this.sumCol="memo";
        return this;
    }

    public GoodsBorrowMstExample sumStoreUuid() {
        this.sumCol="store_uuid";
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

        public Criteria andBillNumberIsNull() {
            addCriterion("bill_number is null");
            return (Criteria) this;
        }

        public Criteria andBillNumberIsNotNull() {
            addCriterion("bill_number is not null");
            return (Criteria) this;
        }

        public Criteria andBillNumberEqualTo(String value) {
            addCriterion("bill_number =", value, "billNumber");
            return (Criteria) this;
        }

        public Criteria andBillNumberNotEqualTo(String value) {
            addCriterion("bill_number <>", value, "billNumber");
            return (Criteria) this;
        }

        public Criteria andBillNumberGreaterThan(String value) {
            addCriterion("bill_number >", value, "billNumber");
            return (Criteria) this;
        }

        public Criteria andBillNumberGreaterThanOrEqualTo(String value) {
            addCriterion("bill_number >=", value, "billNumber");
            return (Criteria) this;
        }

        public Criteria andBillNumberLessThan(String value) {
            addCriterion("bill_number <", value, "billNumber");
            return (Criteria) this;
        }

        public Criteria andBillNumberLessThanOrEqualTo(String value) {
            addCriterion("bill_number <=", value, "billNumber");
            return (Criteria) this;
        }

        public Criteria andBillNumberLike(String value) {
            addCriterion("bill_number like", value, "billNumber");
            return (Criteria) this;
        }

        public Criteria andBillNumberNotLike(String value) {
            addCriterion("bill_number not like", value, "billNumber");
            return (Criteria) this;
        }

        public Criteria andBillNumberIn(List<String> values) {
            addCriterion("bill_number in", values, "billNumber");
            return (Criteria) this;
        }

        public Criteria andBillNumberNotIn(List<String> values) {
            addCriterion("bill_number not in", values, "billNumber");
            return (Criteria) this;
        }

        public Criteria andBillNumberBetween(String value1, String value2) {
            addCriterion("bill_number between", value1, value2, "billNumber");
            return (Criteria) this;
        }

        public Criteria andBillNumberNotBetween(String value1, String value2) {
            addCriterion("bill_number not between", value1, value2, "billNumber");
            return (Criteria) this;
        }

        public Criteria andStatIsNull() {
            addCriterion("stat is null");
            return (Criteria) this;
        }

        public Criteria andStatIsNotNull() {
            addCriterion("stat is not null");
            return (Criteria) this;
        }

        public Criteria andStatEqualTo(String value) {
            addCriterion("stat =", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotEqualTo(String value) {
            addCriterion("stat <>", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThan(String value) {
            addCriterion("stat >", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThanOrEqualTo(String value) {
            addCriterion("stat >=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThan(String value) {
            addCriterion("stat <", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThanOrEqualTo(String value) {
            addCriterion("stat <=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLike(String value) {
            addCriterion("stat like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotLike(String value) {
            addCriterion("stat not like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatIn(List<String> values) {
            addCriterion("stat in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotIn(List<String> values) {
            addCriterion("stat not in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatBetween(String value1, String value2) {
            addCriterion("stat between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotBetween(String value1, String value2) {
            addCriterion("stat not between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andBorrowTypeIsNull() {
            addCriterion("borrow_type is null");
            return (Criteria) this;
        }

        public Criteria andBorrowTypeIsNotNull() {
            addCriterion("borrow_type is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowTypeEqualTo(String value) {
            addCriterion("borrow_type =", value, "borrowType");
            return (Criteria) this;
        }

        public Criteria andBorrowTypeNotEqualTo(String value) {
            addCriterion("borrow_type <>", value, "borrowType");
            return (Criteria) this;
        }

        public Criteria andBorrowTypeGreaterThan(String value) {
            addCriterion("borrow_type >", value, "borrowType");
            return (Criteria) this;
        }

        public Criteria andBorrowTypeGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_type >=", value, "borrowType");
            return (Criteria) this;
        }

        public Criteria andBorrowTypeLessThan(String value) {
            addCriterion("borrow_type <", value, "borrowType");
            return (Criteria) this;
        }

        public Criteria andBorrowTypeLessThanOrEqualTo(String value) {
            addCriterion("borrow_type <=", value, "borrowType");
            return (Criteria) this;
        }

        public Criteria andBorrowTypeLike(String value) {
            addCriterion("borrow_type like", value, "borrowType");
            return (Criteria) this;
        }

        public Criteria andBorrowTypeNotLike(String value) {
            addCriterion("borrow_type not like", value, "borrowType");
            return (Criteria) this;
        }

        public Criteria andBorrowTypeIn(List<String> values) {
            addCriterion("borrow_type in", values, "borrowType");
            return (Criteria) this;
        }

        public Criteria andBorrowTypeNotIn(List<String> values) {
            addCriterion("borrow_type not in", values, "borrowType");
            return (Criteria) this;
        }

        public Criteria andBorrowTypeBetween(String value1, String value2) {
            addCriterion("borrow_type between", value1, value2, "borrowType");
            return (Criteria) this;
        }

        public Criteria andBorrowTypeNotBetween(String value1, String value2) {
            addCriterion("borrow_type not between", value1, value2, "borrowType");
            return (Criteria) this;
        }

        public Criteria andBorrowerIsNull() {
            addCriterion("borrower is null");
            return (Criteria) this;
        }

        public Criteria andBorrowerIsNotNull() {
            addCriterion("borrower is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowerEqualTo(String value) {
            addCriterion("borrower =", value, "borrower");
            return (Criteria) this;
        }

        public Criteria andBorrowerNotEqualTo(String value) {
            addCriterion("borrower <>", value, "borrower");
            return (Criteria) this;
        }

        public Criteria andBorrowerGreaterThan(String value) {
            addCriterion("borrower >", value, "borrower");
            return (Criteria) this;
        }

        public Criteria andBorrowerGreaterThanOrEqualTo(String value) {
            addCriterion("borrower >=", value, "borrower");
            return (Criteria) this;
        }

        public Criteria andBorrowerLessThan(String value) {
            addCriterion("borrower <", value, "borrower");
            return (Criteria) this;
        }

        public Criteria andBorrowerLessThanOrEqualTo(String value) {
            addCriterion("borrower <=", value, "borrower");
            return (Criteria) this;
        }

        public Criteria andBorrowerLike(String value) {
            addCriterion("borrower like", value, "borrower");
            return (Criteria) this;
        }

        public Criteria andBorrowerNotLike(String value) {
            addCriterion("borrower not like", value, "borrower");
            return (Criteria) this;
        }

        public Criteria andBorrowerIn(List<String> values) {
            addCriterion("borrower in", values, "borrower");
            return (Criteria) this;
        }

        public Criteria andBorrowerNotIn(List<String> values) {
            addCriterion("borrower not in", values, "borrower");
            return (Criteria) this;
        }

        public Criteria andBorrowerBetween(String value1, String value2) {
            addCriterion("borrower between", value1, value2, "borrower");
            return (Criteria) this;
        }

        public Criteria andBorrowerNotBetween(String value1, String value2) {
            addCriterion("borrower not between", value1, value2, "borrower");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeIsNull() {
            addCriterion("plan_return_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeIsNotNull() {
            addCriterion("plan_return_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeEqualTo(Date value) {
            addCriterion("plan_return_time =", value, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeNotEqualTo(Date value) {
            addCriterion("plan_return_time <>", value, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeGreaterThan(Date value) {
            addCriterion("plan_return_time >", value, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_return_time >=", value, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeLessThan(Date value) {
            addCriterion("plan_return_time <", value, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeLessThanOrEqualTo(Date value) {
            addCriterion("plan_return_time <=", value, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeIn(List<Date> values) {
            addCriterion("plan_return_time in", values, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeNotIn(List<Date> values) {
            addCriterion("plan_return_time not in", values, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeBetween(Date value1, Date value2) {
            addCriterion("plan_return_time between", value1, value2, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeNotBetween(Date value1, Date value2) {
            addCriterion("plan_return_time not between", value1, value2, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andRealReturnTimeIsNull() {
            addCriterion("real_return_time is null");
            return (Criteria) this;
        }

        public Criteria andRealReturnTimeIsNotNull() {
            addCriterion("real_return_time is not null");
            return (Criteria) this;
        }

        public Criteria andRealReturnTimeEqualTo(Date value) {
            addCriterion("real_return_time =", value, "realReturnTime");
            return (Criteria) this;
        }

        public Criteria andRealReturnTimeNotEqualTo(Date value) {
            addCriterion("real_return_time <>", value, "realReturnTime");
            return (Criteria) this;
        }

        public Criteria andRealReturnTimeGreaterThan(Date value) {
            addCriterion("real_return_time >", value, "realReturnTime");
            return (Criteria) this;
        }

        public Criteria andRealReturnTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("real_return_time >=", value, "realReturnTime");
            return (Criteria) this;
        }

        public Criteria andRealReturnTimeLessThan(Date value) {
            addCriterion("real_return_time <", value, "realReturnTime");
            return (Criteria) this;
        }

        public Criteria andRealReturnTimeLessThanOrEqualTo(Date value) {
            addCriterion("real_return_time <=", value, "realReturnTime");
            return (Criteria) this;
        }

        public Criteria andRealReturnTimeIn(List<Date> values) {
            addCriterion("real_return_time in", values, "realReturnTime");
            return (Criteria) this;
        }

        public Criteria andRealReturnTimeNotIn(List<Date> values) {
            addCriterion("real_return_time not in", values, "realReturnTime");
            return (Criteria) this;
        }

        public Criteria andRealReturnTimeBetween(Date value1, Date value2) {
            addCriterion("real_return_time between", value1, value2, "realReturnTime");
            return (Criteria) this;
        }

        public Criteria andRealReturnTimeNotBetween(Date value1, Date value2) {
            addCriterion("real_return_time not between", value1, value2, "realReturnTime");
            return (Criteria) this;
        }

        public Criteria andBorrowOperatorIsNull() {
            addCriterion("borrow_operator is null");
            return (Criteria) this;
        }

        public Criteria andBorrowOperatorIsNotNull() {
            addCriterion("borrow_operator is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowOperatorEqualTo(String value) {
            addCriterion("borrow_operator =", value, "borrowOperator");
            return (Criteria) this;
        }

        public Criteria andBorrowOperatorNotEqualTo(String value) {
            addCriterion("borrow_operator <>", value, "borrowOperator");
            return (Criteria) this;
        }

        public Criteria andBorrowOperatorGreaterThan(String value) {
            addCriterion("borrow_operator >", value, "borrowOperator");
            return (Criteria) this;
        }

        public Criteria andBorrowOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_operator >=", value, "borrowOperator");
            return (Criteria) this;
        }

        public Criteria andBorrowOperatorLessThan(String value) {
            addCriterion("borrow_operator <", value, "borrowOperator");
            return (Criteria) this;
        }

        public Criteria andBorrowOperatorLessThanOrEqualTo(String value) {
            addCriterion("borrow_operator <=", value, "borrowOperator");
            return (Criteria) this;
        }

        public Criteria andBorrowOperatorLike(String value) {
            addCriterion("borrow_operator like", value, "borrowOperator");
            return (Criteria) this;
        }

        public Criteria andBorrowOperatorNotLike(String value) {
            addCriterion("borrow_operator not like", value, "borrowOperator");
            return (Criteria) this;
        }

        public Criteria andBorrowOperatorIn(List<String> values) {
            addCriterion("borrow_operator in", values, "borrowOperator");
            return (Criteria) this;
        }

        public Criteria andBorrowOperatorNotIn(List<String> values) {
            addCriterion("borrow_operator not in", values, "borrowOperator");
            return (Criteria) this;
        }

        public Criteria andBorrowOperatorBetween(String value1, String value2) {
            addCriterion("borrow_operator between", value1, value2, "borrowOperator");
            return (Criteria) this;
        }

        public Criteria andBorrowOperatorNotBetween(String value1, String value2) {
            addCriterion("borrow_operator not between", value1, value2, "borrowOperator");
            return (Criteria) this;
        }

        public Criteria andBorrowOperateTimeIsNull() {
            addCriterion("borrow_operate_time is null");
            return (Criteria) this;
        }

        public Criteria andBorrowOperateTimeIsNotNull() {
            addCriterion("borrow_operate_time is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowOperateTimeEqualTo(Date value) {
            addCriterion("borrow_operate_time =", value, "borrowOperateTime");
            return (Criteria) this;
        }

        public Criteria andBorrowOperateTimeNotEqualTo(Date value) {
            addCriterion("borrow_operate_time <>", value, "borrowOperateTime");
            return (Criteria) this;
        }

        public Criteria andBorrowOperateTimeGreaterThan(Date value) {
            addCriterion("borrow_operate_time >", value, "borrowOperateTime");
            return (Criteria) this;
        }

        public Criteria andBorrowOperateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("borrow_operate_time >=", value, "borrowOperateTime");
            return (Criteria) this;
        }

        public Criteria andBorrowOperateTimeLessThan(Date value) {
            addCriterion("borrow_operate_time <", value, "borrowOperateTime");
            return (Criteria) this;
        }

        public Criteria andBorrowOperateTimeLessThanOrEqualTo(Date value) {
            addCriterion("borrow_operate_time <=", value, "borrowOperateTime");
            return (Criteria) this;
        }

        public Criteria andBorrowOperateTimeIn(List<Date> values) {
            addCriterion("borrow_operate_time in", values, "borrowOperateTime");
            return (Criteria) this;
        }

        public Criteria andBorrowOperateTimeNotIn(List<Date> values) {
            addCriterion("borrow_operate_time not in", values, "borrowOperateTime");
            return (Criteria) this;
        }

        public Criteria andBorrowOperateTimeBetween(Date value1, Date value2) {
            addCriterion("borrow_operate_time between", value1, value2, "borrowOperateTime");
            return (Criteria) this;
        }

        public Criteria andBorrowOperateTimeNotBetween(Date value1, Date value2) {
            addCriterion("borrow_operate_time not between", value1, value2, "borrowOperateTime");
            return (Criteria) this;
        }

        public Criteria andReturnOperatorIsNull() {
            addCriterion("return_operator is null");
            return (Criteria) this;
        }

        public Criteria andReturnOperatorIsNotNull() {
            addCriterion("return_operator is not null");
            return (Criteria) this;
        }

        public Criteria andReturnOperatorEqualTo(String value) {
            addCriterion("return_operator =", value, "returnOperator");
            return (Criteria) this;
        }

        public Criteria andReturnOperatorNotEqualTo(String value) {
            addCriterion("return_operator <>", value, "returnOperator");
            return (Criteria) this;
        }

        public Criteria andReturnOperatorGreaterThan(String value) {
            addCriterion("return_operator >", value, "returnOperator");
            return (Criteria) this;
        }

        public Criteria andReturnOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("return_operator >=", value, "returnOperator");
            return (Criteria) this;
        }

        public Criteria andReturnOperatorLessThan(String value) {
            addCriterion("return_operator <", value, "returnOperator");
            return (Criteria) this;
        }

        public Criteria andReturnOperatorLessThanOrEqualTo(String value) {
            addCriterion("return_operator <=", value, "returnOperator");
            return (Criteria) this;
        }

        public Criteria andReturnOperatorLike(String value) {
            addCriterion("return_operator like", value, "returnOperator");
            return (Criteria) this;
        }

        public Criteria andReturnOperatorNotLike(String value) {
            addCriterion("return_operator not like", value, "returnOperator");
            return (Criteria) this;
        }

        public Criteria andReturnOperatorIn(List<String> values) {
            addCriterion("return_operator in", values, "returnOperator");
            return (Criteria) this;
        }

        public Criteria andReturnOperatorNotIn(List<String> values) {
            addCriterion("return_operator not in", values, "returnOperator");
            return (Criteria) this;
        }

        public Criteria andReturnOperatorBetween(String value1, String value2) {
            addCriterion("return_operator between", value1, value2, "returnOperator");
            return (Criteria) this;
        }

        public Criteria andReturnOperatorNotBetween(String value1, String value2) {
            addCriterion("return_operator not between", value1, value2, "returnOperator");
            return (Criteria) this;
        }

        public Criteria andReturnOperateTimeIsNull() {
            addCriterion("return_operate_time is null");
            return (Criteria) this;
        }

        public Criteria andReturnOperateTimeIsNotNull() {
            addCriterion("return_operate_time is not null");
            return (Criteria) this;
        }

        public Criteria andReturnOperateTimeEqualTo(Date value) {
            addCriterion("return_operate_time =", value, "returnOperateTime");
            return (Criteria) this;
        }

        public Criteria andReturnOperateTimeNotEqualTo(Date value) {
            addCriterion("return_operate_time <>", value, "returnOperateTime");
            return (Criteria) this;
        }

        public Criteria andReturnOperateTimeGreaterThan(Date value) {
            addCriterion("return_operate_time >", value, "returnOperateTime");
            return (Criteria) this;
        }

        public Criteria andReturnOperateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("return_operate_time >=", value, "returnOperateTime");
            return (Criteria) this;
        }

        public Criteria andReturnOperateTimeLessThan(Date value) {
            addCriterion("return_operate_time <", value, "returnOperateTime");
            return (Criteria) this;
        }

        public Criteria andReturnOperateTimeLessThanOrEqualTo(Date value) {
            addCriterion("return_operate_time <=", value, "returnOperateTime");
            return (Criteria) this;
        }

        public Criteria andReturnOperateTimeIn(List<Date> values) {
            addCriterion("return_operate_time in", values, "returnOperateTime");
            return (Criteria) this;
        }

        public Criteria andReturnOperateTimeNotIn(List<Date> values) {
            addCriterion("return_operate_time not in", values, "returnOperateTime");
            return (Criteria) this;
        }

        public Criteria andReturnOperateTimeBetween(Date value1, Date value2) {
            addCriterion("return_operate_time between", value1, value2, "returnOperateTime");
            return (Criteria) this;
        }

        public Criteria andReturnOperateTimeNotBetween(Date value1, Date value2) {
            addCriterion("return_operate_time not between", value1, value2, "returnOperateTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLstUpdTimeIsNull() {
            addCriterion("lst_upd_time is null");
            return (Criteria) this;
        }

        public Criteria andLstUpdTimeIsNotNull() {
            addCriterion("lst_upd_time is not null");
            return (Criteria) this;
        }

        public Criteria andLstUpdTimeEqualTo(Date value) {
            addCriterion("lst_upd_time =", value, "lstUpdTime");
            return (Criteria) this;
        }

        public Criteria andLstUpdTimeNotEqualTo(Date value) {
            addCriterion("lst_upd_time <>", value, "lstUpdTime");
            return (Criteria) this;
        }

        public Criteria andLstUpdTimeGreaterThan(Date value) {
            addCriterion("lst_upd_time >", value, "lstUpdTime");
            return (Criteria) this;
        }

        public Criteria andLstUpdTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lst_upd_time >=", value, "lstUpdTime");
            return (Criteria) this;
        }

        public Criteria andLstUpdTimeLessThan(Date value) {
            addCriterion("lst_upd_time <", value, "lstUpdTime");
            return (Criteria) this;
        }

        public Criteria andLstUpdTimeLessThanOrEqualTo(Date value) {
            addCriterion("lst_upd_time <=", value, "lstUpdTime");
            return (Criteria) this;
        }

        public Criteria andLstUpdTimeIn(List<Date> values) {
            addCriterion("lst_upd_time in", values, "lstUpdTime");
            return (Criteria) this;
        }

        public Criteria andLstUpdTimeNotIn(List<Date> values) {
            addCriterion("lst_upd_time not in", values, "lstUpdTime");
            return (Criteria) this;
        }

        public Criteria andLstUpdTimeBetween(Date value1, Date value2) {
            addCriterion("lst_upd_time between", value1, value2, "lstUpdTime");
            return (Criteria) this;
        }

        public Criteria andLstUpdTimeNotBetween(Date value1, Date value2) {
            addCriterion("lst_upd_time not between", value1, value2, "lstUpdTime");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("memo is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("memo is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("memo =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("memo <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("memo >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("memo >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("memo <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("memo <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("memo like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("memo not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("memo in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("memo not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("memo between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("memo not between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andStoreUuidIsNull() {
            addCriterion("store_uuid is null");
            return (Criteria) this;
        }

        public Criteria andStoreUuidIsNotNull() {
            addCriterion("store_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andStoreUuidEqualTo(String value) {
            addCriterion("store_uuid =", value, "storeUuid");
            return (Criteria) this;
        }

        public Criteria andStoreUuidNotEqualTo(String value) {
            addCriterion("store_uuid <>", value, "storeUuid");
            return (Criteria) this;
        }

        public Criteria andStoreUuidGreaterThan(String value) {
            addCriterion("store_uuid >", value, "storeUuid");
            return (Criteria) this;
        }

        public Criteria andStoreUuidGreaterThanOrEqualTo(String value) {
            addCriterion("store_uuid >=", value, "storeUuid");
            return (Criteria) this;
        }

        public Criteria andStoreUuidLessThan(String value) {
            addCriterion("store_uuid <", value, "storeUuid");
            return (Criteria) this;
        }

        public Criteria andStoreUuidLessThanOrEqualTo(String value) {
            addCriterion("store_uuid <=", value, "storeUuid");
            return (Criteria) this;
        }

        public Criteria andStoreUuidLike(String value) {
            addCriterion("store_uuid like", value, "storeUuid");
            return (Criteria) this;
        }

        public Criteria andStoreUuidNotLike(String value) {
            addCriterion("store_uuid not like", value, "storeUuid");
            return (Criteria) this;
        }

        public Criteria andStoreUuidIn(List<String> values) {
            addCriterion("store_uuid in", values, "storeUuid");
            return (Criteria) this;
        }

        public Criteria andStoreUuidNotIn(List<String> values) {
            addCriterion("store_uuid not in", values, "storeUuid");
            return (Criteria) this;
        }

        public Criteria andStoreUuidBetween(String value1, String value2) {
            addCriterion("store_uuid between", value1, value2, "storeUuid");
            return (Criteria) this;
        }

        public Criteria andStoreUuidNotBetween(String value1, String value2) {
            addCriterion("store_uuid not between", value1, value2, "storeUuid");
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