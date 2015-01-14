/**
 * The
 * contents
 * of
 * this
 * file
 * are
 * subject
 * to
 * the
 * OpenMRS
 * Public
 * License
 * Version
 * 1.0
 * (the
 * "License");
 * you
 * may
 * not
 * use
 * this
 * file
 * except
 * in
 * compliance
 * with
 * the
 * License.
 * You
 * may
 * obtain
 * a
 * copy
 * of
 * the
 * License
 * at
 * http://license.openmrs.org
 *
 * Software
 * distributed
 * under
 * the
 * License
 * is
 * distributed
 * on
 * an
 * "AS
 * IS"
 * basis,
 * WITHOUT
 * WARRANTY
 * OF
 * ANY
 * KIND,
 * either
 * express
 * or
 * implied.
 * See
 * the
 * License
 * for
 * the
 * specific
 * language
 * governing
 * rights
 * and
 * limitations
 * under
 * the
 * License.
 *
 * Copyright
 * (C)
 * OpenMRS,
 * LLC.
 * All
 * Rights
 * Reserved.
 */
package org.openmrs.module.peer.api.db.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.openmrs.PatientIdentifierType;
import org.openmrs.api.AdministrationService;
import org.openmrs.api.context.Context;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.hibernate.HibernateUtil;
import org.openmrs.module.peer.PeerObs;
import org.openmrs.module.peer.PeerMessages;
import org.openmrs.module.peer.PeerPatient;
import org.openmrs.module.peer.PeerProviders;
import org.openmrs.module.peer.api.db.PeerDAO;
import org.openmrs.util.OpenmrsConstants;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * It
 * is
 * a
 * default
 * implementation
 *
 */
public class HibernatePeerDAO implements PeerDAO {

	protected final Log log = LogFactory.getLog(this.getClass());

	private SessionFactory sessionFactory;

    private  SessionFactory sessionFactoryTwo;

    private  Criteria criteria;
    private List<PatientIdentifierType> identifierTypes;

    /**
	 * @param
	 * sessionFactory
	 * the
	 * sessionFactory
	 * to
	 * set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @return
	 * the
	 * sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



    //


    @Override
    public PeerMessages savePeerMessages(PeerMessages PeerMessages) {
        sessionFactory.getCurrentSession().saveOrUpdate(PeerMessages);

        return PeerMessages;
    }

    @Override
    public List<PeerMessages> getPeerMessages() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PeerMessages.class)
                .add(Expression.eq("voided", false));

        return criteria.list();
    }

    @Override
    public PeerMessages getPeerMessagesByUuid(String uuid) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PeerMessages.class)
                .add(Expression.eq("uuid", uuid));

        @SuppressWarnings("unchecked")
        List<PeerMessages> medicationCategory = criteria.list();
        if (null == medicationCategory || medicationCategory.isEmpty()) {
            return null;
        }
        return medicationCategory.get(0);
    }
    @Override
    public PeerMessages getPeerMessagesByName(String uuid) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PeerMessages.class)
                .add(Expression.eq("name", uuid));

        @SuppressWarnings("unchecked")
        List<PeerMessages> medicationCategory = criteria.list();
        if (null == medicationCategory || medicationCategory.isEmpty()) {
            return null;
        }
        return medicationCategory.get(0);
    }

    @Override
    public List<PeerMessages> getPeerMessagesListByUuid(String uuid) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PeerMessages.class)
                .add(Expression.eq("uuid", uuid)).add(Expression.eq("voided", false));

        return criteria.list();
    }











    @Override
    public PeerObs savePeer(PeerObs x) {
        sessionFactory.getCurrentSession().saveOrUpdate(x);

        return x;
    }


    public PeerObs savePeerList(ArrayList<PeerObs> peerObs) {
        for (PeerObs pharmacy : peerObs) {
            sessionFactory.getCurrentSession().saveOrUpdate(pharmacy);
        }


        return null;
    }

    @Override
    public List<PeerObs> getPeer() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PeerObs.class)
                .add(Expression.eq("voided", false));

        return criteria.list();
    }

    @Override
    public PeerObs getPeerByUuid(String uuid) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PeerObs.class)
                .add(Expression.eq("uuid", uuid));

        @SuppressWarnings("unchecked")
        List<PeerObs> medicationCategory = criteria.list();
        if (null == medicationCategory || medicationCategory.isEmpty()) {
            return null;
        }
        return medicationCategory.get(0);
    }
    @Override
    public PeerObs getPeerByPatientId(PeerPatient uuid) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PeerObs.class)
                .addOrder( Order.desc("timeStampval") )
                .add(Expression.eq("peerPatient", uuid));

        @SuppressWarnings("unchecked")
        List<PeerObs> medicationCategory = criteria.list();
        if (null == medicationCategory || medicationCategory.isEmpty()) {
            return null;
        }
        return medicationCategory.get(0);
    }

    @Override
    public PeerObs getPeerByName(String fname,String lname,String sname, String location) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PeerObs.class)
                .add(Expression.eq("fname", fname)).add(Expression.eq("lname", lname)).add(Expression.eq("sname", sname)).add(Expression.eq("location", location));

        @SuppressWarnings("unchecked")
        List<PeerObs> medicationCategory = criteria.list();
        if (null == medicationCategory || medicationCategory.isEmpty()) {
            return null;
        }
        return medicationCategory.get(0);
    }

    @Override
    public PeerObs getPeerByPhone(String uuid) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PeerObs.class)
                .add(Expression.eq("phone", uuid));

        @SuppressWarnings("unchecked")
        List<PeerObs> medicationCategory = criteria.list();
        if (null == medicationCategory || medicationCategory.isEmpty()) {
            return null;
        }
        return medicationCategory.get(0);
    }

    @Override
    public List<PeerObs> getPeerListByUuid(String uuid) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PeerObs.class)
                .add(Expression.eq("uuid", uuid)).add(Expression.eq("voided", false));

        return criteria.list();
    }


    @SuppressWarnings("unchecked")
    public List<PeerObs> searchPeerByName(String name) throws DAOException {


        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
                PeerObs.class);
        Disjunction or = Restrictions.disjunction();

        or.add(Restrictions.like("firstName", name, MatchMode.ANYWHERE).ignoreCase());
        or.add(Restrictions.like("secondName", name, MatchMode.ANYWHERE).ignoreCase());
        or.add(Restrictions.like("thirdName", name, MatchMode.ANYWHERE).ignoreCase());

       criteria.add(or);



        return criteria.list();


    }






    @Override
    public PeerProviders savePeerProviders(PeerProviders x) {
        sessionFactory.getCurrentSession().saveOrUpdate(x);

        return x;
    }


    public PeerProviders savePeerProvidersList(ArrayList<PeerProviders> mkumbushacdm) {
        for (PeerProviders pharmacy : mkumbushacdm) {
            sessionFactory.getCurrentSession().saveOrUpdate(pharmacy);
        }


        return null;
    }

    @Override
    public List<PeerProviders> getPeerProviders() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PeerProviders.class)
                .add(Expression.eq("voided", false));

        return criteria.list();
    }

    @Override
    public PeerProviders getPeerProvidersByUuid(String uuid) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PeerProviders.class)
                .add(Expression.eq("uuid", uuid));

        @SuppressWarnings("unchecked")
        List<PeerProviders> medicationCategory = criteria.list();
        if (null == medicationCategory || medicationCategory.isEmpty()) {
            return null;
        }
        return medicationCategory.get(0);
    }






















    /**
     * @param sessionFactory
     * @param criteria
     */
    public void  PatientSearchCriteria(SessionFactory sessionFactory, Criteria criteria) {
        this.sessionFactoryTwo = sessionFactory;
        this.criteria = criteria;
    }



    /**
     * Utility method to add identifier expression to an existing criteria
     *
     * @param criteria
     * @param identifier
     * @param identifierTypes
     * @param matchIdentifierExactly
     */
    private void addIdentifierCriterias(Criteria criteria, String identifier, List<PatientIdentifierType> identifierTypes,
                                        boolean matchIdentifierExactly) {
        // TODO add junit test for searching on voided identifiers

        // add the join on the identifiers table
        criteria.createAlias("identifiers", "ids");
        criteria.add(Expression.eq("ids.voided", false));

        // do the identifier restriction
        if (identifier != null) {
            // if the user wants an exact search, match on that.
            if (matchIdentifierExactly) {
                criteria.add(Expression.eq("ids.identifier", identifier));
            } else {
                AdministrationService adminService = Context.getAdministrationService();
                String regex = adminService.getGlobalProperty(OpenmrsConstants.GLOBAL_PROPERTY_PATIENT_IDENTIFIER_REGEX, "");
                String patternSearch = adminService.getGlobalProperty(
                        OpenmrsConstants.GLOBAL_PROPERTY_PATIENT_IDENTIFIER_SEARCH_PATTERN, "");

                // remove padding from identifier search string
                if (Pattern.matches("^\\^.{1}\\*.*$", regex)) {
                    identifier = removePadding(identifier, regex);
                }

                if (StringUtils.hasLength(patternSearch)) {
                    //splitAndAddSearchPattern(criteria, identifier, patternSearch);
                }
                // if the regex is empty, default to a simple "like" search or if
                // we're in hsql world, also only do the simple like search (because
                // hsql doesn't know how to deal with 'regexp'
                else if (regex.equals("") || HibernateUtil.isHSQLDialect(sessionFactory)) {
                    addCriterionForSimpleSearch(criteria, identifier, adminService);
                }
                // if the regex is present, search on that
                else {
//                    regex = replaceSearchString(regex, identifier);
//                    criteria.add(Restrictions.sqlRestriction("identifier regexp ?", regex, Hibernate.STRING));
                }
            }
        }

        // TODO add a junit test for patientIdentifierType restrictions

        // do the type restriction
        if (identifierTypes.size() > 0) {
            criteria.add(Expression.in("ids.identifierType", identifierTypes));
        }
    }


    /**
     * Utility method to add prefix and suffix like expression
     *
     * @param criteria
     * @param identifier
     * @param adminService
     */
    private void addCriterionForSimpleSearch(Criteria criteria, String identifier, AdministrationService adminService) {
        String prefix = adminService.getGlobalProperty(OpenmrsConstants.GLOBAL_PROPERTY_PATIENT_IDENTIFIER_PREFIX, "");
        String suffix = adminService.getGlobalProperty(OpenmrsConstants.GLOBAL_PROPERTY_PATIENT_IDENTIFIER_SUFFIX, "");
        StringBuffer likeString = new StringBuffer(prefix).append(identifier).append(suffix);
        criteria.add(Expression.like("ids.identifier", likeString.toString()));
    }



    /**
     * Utility method to remove padding from the identifier.
     *
     * @param identifier
     * @param regex
     * @return identifier without the padding.
     */
    private String removePadding(String identifier, String regex) {
        String padding = regex.substring(regex.indexOf("^") + 1, regex.indexOf("*"));
        Pattern pattern = Pattern.compile("^" + padding + "+");
        identifier = pattern.matcher(identifier).replaceFirst("");
        return identifier;
    }

    public Criteria x(String name, String identifier, List<PatientIdentifierType> identifierTypes,
                                    boolean matchIdentifierExactly, boolean orderByNames) {
        name = HibernateUtil.escapeSqlWildcards(name, sessionFactory);
        identifier = HibernateUtil.escapeSqlWildcards(identifier, sessionFactory);

        criteria.createAlias("fname", "name");
        if (orderByNames) {
            criteria.addOrder(Order.asc("name.givenName"));
            criteria.addOrder(Order.asc("name.middleName"));
            criteria.addOrder(Order.asc("name.familyName"));
        }

        // get only distinct patients
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

        if (name != null) {
            addNameCriterias(criteria, name);
        }

        // do the restriction on either identifier string or types
        if (identifier != null || identifierTypes.size() > 0) {
            addIdentifierCriterias(criteria, identifier, identifierTypes, matchIdentifierExactly);
        }

        // TODO add junit test for searching on voided patients

        // make sure the patient object isn't voided
        criteria.add(Expression.eq("voided", false));

        return criteria;
    }
    private void addNameCriterias(Criteria criteria, String name) {
        // TODO simple name search to start testing, will need to make "real"
        // name search
        // i.e. split on whitespace, guess at first/last name, etc
        // TODO return the matched name instead of the primary name
        // possible solution: "select new" org.openmrs.PatientListItem and
        // return a list of those

        name = name.replaceAll("  ", " ");
        name = name.replace(", ", " ");
        String[] names = name.split(" ");

        // TODO add junit test for searching on voided patient names
        if (names.length > 0) {
            String nameSoFar = names[0];
            for (int i = 0; i < names.length; i++) {
                String n = names[i];
                if (n != null && n.length() > 0) {
                    LogicalExpression oneNameSearch = getNameSearch(n);
                    LogicalExpression searchExpression = oneNameSearch;
                    if (i > 0) {
                        nameSoFar += " " + n;
                        LogicalExpression fullNameSearch = getNameSearch(nameSoFar);
                        searchExpression = Expression.or(oneNameSearch, fullNameSearch);
                    }
                    criteria.add(searchExpression);
                }
            }
        }
    }
    private LogicalExpression getNameSearch(String name) {

        MatchMode mode = MatchMode.START;
        String matchModeConstant = OpenmrsConstants.GLOBAL_PROPERTY_PATIENT_SEARCH_MATCH_MODE;
        String modeGp = Context.getAdministrationService().getGlobalProperty(matchModeConstant);
        if (OpenmrsConstants.GLOBAL_PROPERTY_PATIENT_SEARCH_MATCH_ANYWHERE.equalsIgnoreCase(modeGp)) {
            mode = MatchMode.ANYWHERE;
        }
        SimpleExpression fname = Expression.like("name.fname", name, mode);
        SimpleExpression lname = Expression.like("name.lname", name, mode);
        SimpleExpression sname = Expression.like("name.sname", name, mode);

        return Expression.and(Expression.eq("name.voided", false), Expression.or(sname,
                Expression.or(lname, fname)));
    }




    @Override
    public PeerProviders getPeerProvidersByName(String fname,String lname) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PeerProviders.class)
                .add(Expression.eq("fname", fname)).add(Expression.eq("lname", lname));

        @SuppressWarnings("unchecked")
        List<PeerProviders> medicationCategory = criteria.list();
        if (null == medicationCategory || medicationCategory.isEmpty()) {
            return null;
        }
        return medicationCategory.get(0);
    }



    @Override
    public PeerProviders getPeerProvidersByUName(String uname ,String pwd) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PeerProviders.class)
                .add(Expression.eq("uname", uname));

        @SuppressWarnings("unchecked")
        List<PeerProviders> medicationCategory = criteria.list();
        if (null == medicationCategory || medicationCategory.isEmpty()) {
            return null;
        }
        return medicationCategory.get(0);
    }



    @Override
    public PeerPatient savePeerPatient(PeerPatient peerPatient) {
        sessionFactory.getCurrentSession().saveOrUpdate(peerPatient);
        return peerPatient;
     }

    @Override
    public PeerPatient savePeerPatientList(ArrayList<PeerPatient> peerPatients) {
        for (PeerPatient peerPatient : peerPatients) {
            sessionFactory.getCurrentSession().saveOrUpdate(peerPatient);
        }


        return null;
    }


    @Override
    public List<PeerPatient> getPeerPatients() {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PeerPatient.class)
                .add(Expression.eq("voided", false));

        return criteria.list();
    }

    @Override
    public List<PeerPatient> searchPeerPatientByName(String name) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
                PeerPatient.class);
        Disjunction or = Restrictions.disjunction();

        or.add(Restrictions.like("firstName", name, MatchMode.ANYWHERE).ignoreCase());
        or.add(Restrictions.like("secondName", name, MatchMode.ANYWHERE).ignoreCase());
        or.add(Restrictions.like("thirdName", name, MatchMode.ANYWHERE).ignoreCase());

        criteria.add(or);



        return criteria.list();


    }

    @Override
    public PeerPatient getPeerPatientByUuid(String uuid) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PeerObs.class)
                .add(Expression.eq("uuid", uuid));

        @SuppressWarnings("unchecked")
        List<PeerPatient> peerPatient = criteria.list();
        if (null == peerPatient || peerPatient.isEmpty()) {
            return null;
        }

        return peerPatient.get(0);
    }

}