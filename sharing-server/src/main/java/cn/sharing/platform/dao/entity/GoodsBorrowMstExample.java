package cn.sharing.platform.dao.entity;

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

    public GoodsBorrowMstExample sumPlanBackTime() {
        this.sumCol="plan_back_time";
        return this;
    }

    public GoodsBorrowMstExample sumRealBackTime() {
        this.sumCol="real_back_time";
        return this;
    }

    public GoodsBorrowMstExample sumBorrowDealer() {
        this.sumCol="borrow_dealer";
        return this;
    }

    public GoodsBorrowMstExample sumBorrowDealTime() {
        this.sumCol="borrow_deal_time";
        return this;
    }

    public GoodsBorrowMstExample sumBackDealer() {
        this.sumCol="back_dealer";
        return this;
    }

    public GoodsBorrowMstExample sumBackDealTime() {
        this.sumCol="back_deal_time";
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

    public GoodsBorrowMstExample sumBorrowPayUuid() {
        this.sumCol="borrow_pay_uuid";
        return this;
    }

    public GoodsBorrowMstExample sumBackPayUuid() {
        this.sumCol="back_pay_uuid";
        return this;
    }

    public GoodsBorrowMstExample sumCompensatePayUuid() {
        this.sumCol="compensate_pay_uuid";
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

        public Criteria andPlanBackTimeIsNull() {
            addCriterion("plan_back_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanBackTimeIsNotNull() {
            addCriterion("plan_back_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanBackTimeEqualTo(Date value) {
            addCriterion("plan_back_time =", value, "planBackTime");
            return (Criteria) this;
        }

        public Criteria andPlanBackTimeNotEqualTo(Date value) {
            addCriterion("plan_back_time <>", value, "planBackTime");
            return (Criteria) this;
        }

        public Criteria andPlanBackTimeGreaterThan(Date value) {
            addCriterion("plan_back_time >", value, "planBackTime");
            return (Criteria) this;
        }

        public Criteria andPlanBackTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plan_back_time >=", value, "planBackTime");
            return (Criteria) this;
        }

        public Criteria andPlanBackTimeLessThan(Date value) {
            addCriterion("plan_back_time <", value, "planBackTime");
            return (Criteria) this;
        }

        public Criteria andPlanBackTimeLessThanOrEqualTo(Date value) {
            addCriterion("plan_back_time <=", value, "planBackTime");
            return (Criteria) this;
        }

        public Criteria andPlanBackTimeIn(List<Date> values) {
            addCriterion("plan_back_time in", values, "planBackTime");
            return (Criteria) this;
        }

        public Criteria andPlanBackTimeNotIn(List<Date> values) {
            addCriterion("plan_back_time not in", values, "planBackTime");
            return (Criteria) this;
        }

        public Criteria andPlanBackTimeBetween(Date value1, Date value2) {
            addCriterion("plan_back_time between", value1, value2, "planBackTime");
            return (Criteria) this;
        }

        public Criteria andPlanBackTimeNotBetween(Date value1, Date value2) {
            addCriterion("plan_back_time not between", value1, value2, "planBackTime");
            return (Criteria) this;
        }

        public Criteria andRealBackTimeIsNull() {
            addCriterion("real_back_time is null");
            return (Criteria) this;
        }

        public Criteria andRealBackTimeIsNotNull() {
            addCriterion("real_back_time is not null");
            return (Criteria) this;
        }

        public Criteria andRealBackTimeEqualTo(Date value) {
            addCriterion("real_back_time =", value, "realBackTime");
            return (Criteria) this;
        }

        public Criteria andRealBackTimeNotEqualTo(Date value) {
            addCriterion("real_back_time <>", value, "realBackTime");
            return (Criteria) this;
        }

        public Criteria andRealBackTimeGreaterThan(Date value) {
            addCriterion("real_back_time >", value, "realBackTime");
            return (Criteria) this;
        }

        public Criteria andRealBackTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("real_back_time >=", value, "realBackTime");
            return (Criteria) this;
        }

        public Criteria andRealBackTimeLessThan(Date value) {
            addCriterion("real_back_time <", value, "realBackTime");
            return (Criteria) this;
        }

        public Criteria andRealBackTimeLessThanOrEqualTo(Date value) {
            addCriterion("real_back_time <=", value, "realBackTime");
            return (Criteria) this;
        }

        public Criteria andRealBackTimeIn(List<Date> values) {
            addCriterion("real_back_time in", values, "realBackTime");
            return (Criteria) this;
        }

        public Criteria andRealBackTimeNotIn(List<Date> values) {
            addCriterion("real_back_time not in", values, "realBackTime");
            return (Criteria) this;
        }

        public Criteria andRealBackTimeBetween(Date value1, Date value2) {
            addCriterion("real_back_time between", value1, value2, "realBackTime");
            return (Criteria) this;
        }

        public Criteria andRealBackTimeNotBetween(Date value1, Date value2) {
            addCriterion("real_back_time not between", value1, value2, "realBackTime");
            return (Criteria) this;
        }

        public Criteria andBorrowDealerIsNull() {
            addCriterion("borrow_dealer is null");
            return (Criteria) this;
        }

        public Criteria andBorrowDealerIsNotNull() {
            addCriterion("borrow_dealer is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowDealerEqualTo(String value) {
            addCriterion("borrow_dealer =", value, "borrowDealer");
            return (Criteria) this;
        }

        public Criteria andBorrowDealerNotEqualTo(String value) {
            addCriterion("borrow_dealer <>", value, "borrowDealer");
            return (Criteria) this;
        }

        public Criteria andBorrowDealerGreaterThan(String value) {
            addCriterion("borrow_dealer >", value, "borrowDealer");
            return (Criteria) this;
        }

        public Criteria andBorrowDealerGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_dealer >=", value, "borrowDealer");
            return (Criteria) this;
        }

        public Criteria andBorrowDealerLessThan(String value) {
            addCriterion("borrow_dealer <", value, "borrowDealer");
            return (Criteria) this;
        }

        public Criteria andBorrowDealerLessThanOrEqualTo(String value) {
            addCriterion("borrow_dealer <=", value, "borrowDealer");
            return (Criteria) this;
        }

        public Criteria andBorrowDealerLike(String value) {
            addCriterion("borrow_dealer like", value, "borrowDealer");
            return (Criteria) this;
        }

        public Criteria andBorrowDealerNotLike(String value) {
            addCriterion("borrow_dealer not like", value, "borrowDealer");
            return (Criteria) this;
        }

        public Criteria andBorrowDealerIn(List<String> values) {
            addCriterion("borrow_dealer in", values, "borrowDealer");
            return (Criteria) this;
        }

        public Criteria andBorrowDealerNotIn(List<String> values) {
            addCriterion("borrow_dealer not in", values, "borrowDealer");
            return (Criteria) this;
        }

        public Criteria andBorrowDealerBetween(String value1, String value2) {
            addCriterion("borrow_dealer between", value1, value2, "borrowDealer");
            return (Criteria) this;
        }

        public Criteria andBorrowDealerNotBetween(String value1, String value2) {
            addCriterion("borrow_dealer not between", value1, value2, "borrowDealer");
            return (Criteria) this;
        }

        public Criteria andBorrowDealTimeIsNull() {
            addCriterion("borrow_deal_time is null");
            return (Criteria) this;
        }

        public Criteria andBorrowDealTimeIsNotNull() {
            addCriterion("borrow_deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowDealTimeEqualTo(Date value) {
            addCriterion("borrow_deal_time =", value, "borrowDealTime");
            return (Criteria) this;
        }

        public Criteria andBorrowDealTimeNotEqualTo(Date value) {
            addCriterion("borrow_deal_time <>", value, "borrowDealTime");
            return (Criteria) this;
        }

        public Criteria andBorrowDealTimeGreaterThan(Date value) {
            addCriterion("borrow_deal_time >", value, "borrowDealTime");
            return (Criteria) this;
        }

        public Criteria andBorrowDealTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("borrow_deal_time >=", value, "borrowDealTime");
            return (Criteria) this;
        }

        public Criteria andBorrowDealTimeLessThan(Date value) {
            addCriterion("borrow_deal_time <", value, "borrowDealTime");
            return (Criteria) this;
        }

        public Criteria andBorrowDealTimeLessThanOrEqualTo(Date value) {
            addCriterion("borrow_deal_time <=", value, "borrowDealTime");
            return (Criteria) this;
        }

        public Criteria andBorrowDealTimeIn(List<Date> values) {
            addCriterion("borrow_deal_time in", values, "borrowDealTime");
            return (Criteria) this;
        }

        public Criteria andBorrowDealTimeNotIn(List<Date> values) {
            addCriterion("borrow_deal_time not in", values, "borrowDealTime");
            return (Criteria) this;
        }

        public Criteria andBorrowDealTimeBetween(Date value1, Date value2) {
            addCriterion("borrow_deal_time between", value1, value2, "borrowDealTime");
            return (Criteria) this;
        }

        public Criteria andBorrowDealTimeNotBetween(Date value1, Date value2) {
            addCriterion("borrow_deal_time not between", value1, value2, "borrowDealTime");
            return (Criteria) this;
        }

        public Criteria andBackDealerIsNull() {
            addCriterion("back_dealer is null");
            return (Criteria) this;
        }

        public Criteria andBackDealerIsNotNull() {
            addCriterion("back_dealer is not null");
            return (Criteria) this;
        }

        public Criteria andBackDealerEqualTo(String value) {
            addCriterion("back_dealer =", value, "backDealer");
            return (Criteria) this;
        }

        public Criteria andBackDealerNotEqualTo(String value) {
            addCriterion("back_dealer <>", value, "backDealer");
            return (Criteria) this;
        }

        public Criteria andBackDealerGreaterThan(String value) {
            addCriterion("back_dealer >", value, "backDealer");
            return (Criteria) this;
        }

        public Criteria andBackDealerGreaterThanOrEqualTo(String value) {
            addCriterion("back_dealer >=", value, "backDealer");
            return (Criteria) this;
        }

        public Criteria andBackDealerLessThan(String value) {
            addCriterion("back_dealer <", value, "backDealer");
            return (Criteria) this;
        }

        public Criteria andBackDealerLessThanOrEqualTo(String value) {
            addCriterion("back_dealer <=", value, "backDealer");
            return (Criteria) this;
        }

        public Criteria andBackDealerLike(String value) {
            addCriterion("back_dealer like", value, "backDealer");
            return (Criteria) this;
        }

        public Criteria andBackDealerNotLike(String value) {
            addCriterion("back_dealer not like", value, "backDealer");
            return (Criteria) this;
        }

        public Criteria andBackDealerIn(List<String> values) {
            addCriterion("back_dealer in", values, "backDealer");
            return (Criteria) this;
        }

        public Criteria andBackDealerNotIn(List<String> values) {
            addCriterion("back_dealer not in", values, "backDealer");
            return (Criteria) this;
        }

        public Criteria andBackDealerBetween(String value1, String value2) {
            addCriterion("back_dealer between", value1, value2, "backDealer");
            return (Criteria) this;
        }

        public Criteria andBackDealerNotBetween(String value1, String value2) {
            addCriterion("back_dealer not between", value1, value2, "backDealer");
            return (Criteria) this;
        }

        public Criteria andBackDealTimeIsNull() {
            addCriterion("back_deal_time is null");
            return (Criteria) this;
        }

        public Criteria andBackDealTimeIsNotNull() {
            addCriterion("back_deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andBackDealTimeEqualTo(Date value) {
            addCriterion("back_deal_time =", value, "backDealTime");
            return (Criteria) this;
        }

        public Criteria andBackDealTimeNotEqualTo(Date value) {
            addCriterion("back_deal_time <>", value, "backDealTime");
            return (Criteria) this;
        }

        public Criteria andBackDealTimeGreaterThan(Date value) {
            addCriterion("back_deal_time >", value, "backDealTime");
            return (Criteria) this;
        }

        public Criteria andBackDealTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("back_deal_time >=", value, "backDealTime");
            return (Criteria) this;
        }

        public Criteria andBackDealTimeLessThan(Date value) {
            addCriterion("back_deal_time <", value, "backDealTime");
            return (Criteria) this;
        }

        public Criteria andBackDealTimeLessThanOrEqualTo(Date value) {
            addCriterion("back_deal_time <=", value, "backDealTime");
            return (Criteria) this;
        }

        public Criteria andBackDealTimeIn(List<Date> values) {
            addCriterion("back_deal_time in", values, "backDealTime");
            return (Criteria) this;
        }

        public Criteria andBackDealTimeNotIn(List<Date> values) {
            addCriterion("back_deal_time not in", values, "backDealTime");
            return (Criteria) this;
        }

        public Criteria andBackDealTimeBetween(Date value1, Date value2) {
            addCriterion("back_deal_time between", value1, value2, "backDealTime");
            return (Criteria) this;
        }

        public Criteria andBackDealTimeNotBetween(Date value1, Date value2) {
            addCriterion("back_deal_time not between", value1, value2, "backDealTime");
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

        public Criteria andBorrowPayUuidIsNull() {
            addCriterion("borrow_pay_uuid is null");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidIsNotNull() {
            addCriterion("borrow_pay_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidEqualTo(String value) {
            addCriterion("borrow_pay_uuid =", value, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidNotEqualTo(String value) {
            addCriterion("borrow_pay_uuid <>", value, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidGreaterThan(String value) {
            addCriterion("borrow_pay_uuid >", value, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_pay_uuid >=", value, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidLessThan(String value) {
            addCriterion("borrow_pay_uuid <", value, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidLessThanOrEqualTo(String value) {
            addCriterion("borrow_pay_uuid <=", value, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidLike(String value) {
            addCriterion("borrow_pay_uuid like", value, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidNotLike(String value) {
            addCriterion("borrow_pay_uuid not like", value, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidIn(List<String> values) {
            addCriterion("borrow_pay_uuid in", values, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidNotIn(List<String> values) {
            addCriterion("borrow_pay_uuid not in", values, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidBetween(String value1, String value2) {
            addCriterion("borrow_pay_uuid between", value1, value2, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBorrowPayUuidNotBetween(String value1, String value2) {
            addCriterion("borrow_pay_uuid not between", value1, value2, "borrowPayUuid");
            return (Criteria) this;
        }

        public Criteria andBackPayUuidIsNull() {
            addCriterion("back_pay_uuid is null");
            return (Criteria) this;
        }

        public Criteria andBackPayUuidIsNotNull() {
            addCriterion("back_pay_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andBackPayUuidEqualTo(String value) {
            addCriterion("back_pay_uuid =", value, "backPayUuid");
            return (Criteria) this;
        }

        public Criteria andBackPayUuidNotEqualTo(String value) {
            addCriterion("back_pay_uuid <>", value, "backPayUuid");
            return (Criteria) this;
        }

        public Criteria andBackPayUuidGreaterThan(String value) {
            addCriterion("back_pay_uuid >", value, "backPayUuid");
            return (Criteria) this;
        }

        public Criteria andBackPayUuidGreaterThanOrEqualTo(String value) {
            addCriterion("back_pay_uuid >=", value, "backPayUuid");
            return (Criteria) this;
        }

        public Criteria andBackPayUuidLessThan(String value) {
            addCriterion("back_pay_uuid <", value, "backPayUuid");
            return (Criteria) this;
        }

        public Criteria andBackPayUuidLessThanOrEqualTo(String value) {
            addCriterion("back_pay_uuid <=", value, "backPayUuid");
            return (Criteria) this;
        }

        public Criteria andBackPayUuidLike(String value) {
            addCriterion("back_pay_uuid like", value, "backPayUuid");
            return (Criteria) this;
        }

        public Criteria andBackPayUuidNotLike(String value) {
            addCriterion("back_pay_uuid not like", value, "backPayUuid");
            return (Criteria) this;
        }

        public Criteria andBackPayUuidIn(List<String> values) {
            addCriterion("back_pay_uuid in", values, "backPayUuid");
            return (Criteria) this;
        }

        public Criteria andBackPayUuidNotIn(List<String> values) {
            addCriterion("back_pay_uuid not in", values, "backPayUuid");
            return (Criteria) this;
        }

        public Criteria andBackPayUuidBetween(String value1, String value2) {
            addCriterion("back_pay_uuid between", value1, value2, "backPayUuid");
            return (Criteria) this;
        }

        public Criteria andBackPayUuidNotBetween(String value1, String value2) {
            addCriterion("back_pay_uuid not between", value1, value2, "backPayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidIsNull() {
            addCriterion("compensate_pay_uuid is null");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidIsNotNull() {
            addCriterion("compensate_pay_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidEqualTo(String value) {
            addCriterion("compensate_pay_uuid =", value, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidNotEqualTo(String value) {
            addCriterion("compensate_pay_uuid <>", value, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidGreaterThan(String value) {
            addCriterion("compensate_pay_uuid >", value, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidGreaterThanOrEqualTo(String value) {
            addCriterion("compensate_pay_uuid >=", value, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidLessThan(String value) {
            addCriterion("compensate_pay_uuid <", value, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidLessThanOrEqualTo(String value) {
            addCriterion("compensate_pay_uuid <=", value, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidLike(String value) {
            addCriterion("compensate_pay_uuid like", value, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidNotLike(String value) {
            addCriterion("compensate_pay_uuid not like", value, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidIn(List<String> values) {
            addCriterion("compensate_pay_uuid in", values, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidNotIn(List<String> values) {
            addCriterion("compensate_pay_uuid not in", values, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidBetween(String value1, String value2) {
            addCriterion("compensate_pay_uuid between", value1, value2, "compensatePayUuid");
            return (Criteria) this;
        }

        public Criteria andCompensatePayUuidNotBetween(String value1, String value2) {
            addCriterion("compensate_pay_uuid not between", value1, value2, "compensatePayUuid");
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