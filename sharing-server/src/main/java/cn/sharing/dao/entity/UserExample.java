package cn.sharing.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private String sumCol;

    private Integer offset;

    private Integer limit;

    public UserExample() {
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

    public UserExample sumUuid() {
        this.sumCol="UUID";
        return this;
    }

    public UserExample sumCode() {
        this.sumCol="CODE";
        return this;
    }

    public UserExample sumName() {
        this.sumCol="NAME";
        return this;
    }

    public UserExample sumType() {
        this.sumCol="TYPE";
        return this;
    }

    public UserExample sumGroupuuid() {
        this.sumCol="GROUPUUID";
        return this;
    }

    public UserExample sumPassword() {
        this.sumCol="PASSWORD";
        return this;
    }

    public UserExample sumLogintime() {
        this.sumCol="LOGINTIME";
        return this;
    }

    public UserExample sumMobile() {
        this.sumCol="MOBILE";
        return this;
    }

    public UserExample sumLastupdtime() {
        this.sumCol="LASTUPDTIME";
        return this;
    }

    public UserExample sumMemo() {
        this.sumCol="MEMO";
        return this;
    }

    public UserExample sumStoreuuid() {
        this.sumCol="STOREUUID";
        return this;
    }

    public UserExample sumStorecode() {
        this.sumCol="STORECODE";
        return this;
    }

    public UserExample sumStorename() {
        this.sumCol="STORENAME";
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

    public UserExample page(int offset, int limit) {
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

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andGroupuuidIsNull() {
            addCriterion("GROUPUUID is null");
            return (Criteria) this;
        }

        public Criteria andGroupuuidIsNotNull() {
            addCriterion("GROUPUUID is not null");
            return (Criteria) this;
        }

        public Criteria andGroupuuidEqualTo(String value) {
            addCriterion("GROUPUUID =", value, "groupuuid");
            return (Criteria) this;
        }

        public Criteria andGroupuuidNotEqualTo(String value) {
            addCriterion("GROUPUUID <>", value, "groupuuid");
            return (Criteria) this;
        }

        public Criteria andGroupuuidGreaterThan(String value) {
            addCriterion("GROUPUUID >", value, "groupuuid");
            return (Criteria) this;
        }

        public Criteria andGroupuuidGreaterThanOrEqualTo(String value) {
            addCriterion("GROUPUUID >=", value, "groupuuid");
            return (Criteria) this;
        }

        public Criteria andGroupuuidLessThan(String value) {
            addCriterion("GROUPUUID <", value, "groupuuid");
            return (Criteria) this;
        }

        public Criteria andGroupuuidLessThanOrEqualTo(String value) {
            addCriterion("GROUPUUID <=", value, "groupuuid");
            return (Criteria) this;
        }

        public Criteria andGroupuuidLike(String value) {
            addCriterion("GROUPUUID like", value, "groupuuid");
            return (Criteria) this;
        }

        public Criteria andGroupuuidNotLike(String value) {
            addCriterion("GROUPUUID not like", value, "groupuuid");
            return (Criteria) this;
        }

        public Criteria andGroupuuidIn(List<String> values) {
            addCriterion("GROUPUUID in", values, "groupuuid");
            return (Criteria) this;
        }

        public Criteria andGroupuuidNotIn(List<String> values) {
            addCriterion("GROUPUUID not in", values, "groupuuid");
            return (Criteria) this;
        }

        public Criteria andGroupuuidBetween(String value1, String value2) {
            addCriterion("GROUPUUID between", value1, value2, "groupuuid");
            return (Criteria) this;
        }

        public Criteria andGroupuuidNotBetween(String value1, String value2) {
            addCriterion("GROUPUUID not between", value1, value2, "groupuuid");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andLogintimeIsNull() {
            addCriterion("LOGINTIME is null");
            return (Criteria) this;
        }

        public Criteria andLogintimeIsNotNull() {
            addCriterion("LOGINTIME is not null");
            return (Criteria) this;
        }

        public Criteria andLogintimeEqualTo(Date value) {
            addCriterion("LOGINTIME =", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotEqualTo(Date value) {
            addCriterion("LOGINTIME <>", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeGreaterThan(Date value) {
            addCriterion("LOGINTIME >", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LOGINTIME >=", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeLessThan(Date value) {
            addCriterion("LOGINTIME <", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeLessThanOrEqualTo(Date value) {
            addCriterion("LOGINTIME <=", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeIn(List<Date> values) {
            addCriterion("LOGINTIME in", values, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotIn(List<Date> values) {
            addCriterion("LOGINTIME not in", values, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeBetween(Date value1, Date value2) {
            addCriterion("LOGINTIME between", value1, value2, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotBetween(Date value1, Date value2) {
            addCriterion("LOGINTIME not between", value1, value2, "logintime");
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

        public Criteria andStorecodeIsNull() {
            addCriterion("STORECODE is null");
            return (Criteria) this;
        }

        public Criteria andStorecodeIsNotNull() {
            addCriterion("STORECODE is not null");
            return (Criteria) this;
        }

        public Criteria andStorecodeEqualTo(String value) {
            addCriterion("STORECODE =", value, "storecode");
            return (Criteria) this;
        }

        public Criteria andStorecodeNotEqualTo(String value) {
            addCriterion("STORECODE <>", value, "storecode");
            return (Criteria) this;
        }

        public Criteria andStorecodeGreaterThan(String value) {
            addCriterion("STORECODE >", value, "storecode");
            return (Criteria) this;
        }

        public Criteria andStorecodeGreaterThanOrEqualTo(String value) {
            addCriterion("STORECODE >=", value, "storecode");
            return (Criteria) this;
        }

        public Criteria andStorecodeLessThan(String value) {
            addCriterion("STORECODE <", value, "storecode");
            return (Criteria) this;
        }

        public Criteria andStorecodeLessThanOrEqualTo(String value) {
            addCriterion("STORECODE <=", value, "storecode");
            return (Criteria) this;
        }

        public Criteria andStorecodeLike(String value) {
            addCriterion("STORECODE like", value, "storecode");
            return (Criteria) this;
        }

        public Criteria andStorecodeNotLike(String value) {
            addCriterion("STORECODE not like", value, "storecode");
            return (Criteria) this;
        }

        public Criteria andStorecodeIn(List<String> values) {
            addCriterion("STORECODE in", values, "storecode");
            return (Criteria) this;
        }

        public Criteria andStorecodeNotIn(List<String> values) {
            addCriterion("STORECODE not in", values, "storecode");
            return (Criteria) this;
        }

        public Criteria andStorecodeBetween(String value1, String value2) {
            addCriterion("STORECODE between", value1, value2, "storecode");
            return (Criteria) this;
        }

        public Criteria andStorecodeNotBetween(String value1, String value2) {
            addCriterion("STORECODE not between", value1, value2, "storecode");
            return (Criteria) this;
        }

        public Criteria andStorenameIsNull() {
            addCriterion("STORENAME is null");
            return (Criteria) this;
        }

        public Criteria andStorenameIsNotNull() {
            addCriterion("STORENAME is not null");
            return (Criteria) this;
        }

        public Criteria andStorenameEqualTo(String value) {
            addCriterion("STORENAME =", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameNotEqualTo(String value) {
            addCriterion("STORENAME <>", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameGreaterThan(String value) {
            addCriterion("STORENAME >", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameGreaterThanOrEqualTo(String value) {
            addCriterion("STORENAME >=", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameLessThan(String value) {
            addCriterion("STORENAME <", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameLessThanOrEqualTo(String value) {
            addCriterion("STORENAME <=", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameLike(String value) {
            addCriterion("STORENAME like", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameNotLike(String value) {
            addCriterion("STORENAME not like", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameIn(List<String> values) {
            addCriterion("STORENAME in", values, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameNotIn(List<String> values) {
            addCriterion("STORENAME not in", values, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameBetween(String value1, String value2) {
            addCriterion("STORENAME between", value1, value2, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameNotBetween(String value1, String value2) {
            addCriterion("STORENAME not between", value1, value2, "storename");
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