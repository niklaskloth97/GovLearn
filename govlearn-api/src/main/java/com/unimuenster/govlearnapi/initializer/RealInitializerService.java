package com.unimuenster.govlearnapi.initializer;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.unimuenster.govlearnapi.category.entity.Category;
import com.unimuenster.govlearnapi.category.repository.CategoryRepository;
import com.unimuenster.govlearnapi.core.config.enums.Format;
import com.unimuenster.govlearnapi.core.config.enums.Skilllevel;
import com.unimuenster.govlearnapi.core.config.enums.Verantwortungsbereich;
import com.unimuenster.govlearnapi.course.entity.Course;
import com.unimuenster.govlearnapi.course.repository.CourseRepository;
import com.unimuenster.govlearnapi.feedback.entity.Feedback;
import com.unimuenster.govlearnapi.tags.entity.*;
import com.unimuenster.govlearnapi.tags.repository.*;
import com.unimuenster.govlearnapi.user.entity.UserEntity;
import com.unimuenster.govlearnapi.user.repository.UserRepository;
import io.swagger.v3.core.util.Json;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.*;

@Getter
@Slf4j
@Service
@RequiredArgsConstructor
public class RealInitializerService {
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final TagRepository tagRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserTagRepository userTagRepository;
    private final CourseTagRepository courseTagRepository;
    private final CategoryRepository categoryRepository;
    private final RoleTagRepository roleTagRepository;
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;
    private final EntityManager entityManager;

    private UserEntity user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11;
    private Course course1, course2, course3, course4, course5, course6, course7, course8, course9, course10, course11, course12, course13, course14, course15, course16, course17, course18, course19, course20, course21, course22, course23, course24, course25, course26;
    private Category businessCategory, organisatorischCategory, RechtlichCategory, softSkillsCategory, sozioTechnischCategory, technischCategory, oeffenlichPolitischCategory;
    private Tag tagChangemanagement, tagProjektmanagement, tagProjektplanung, tagProjekterfolgskontrolle, tagResourcenmanagement, tagMarketing, tagQulitaetsmanagement, tagRisikomanagement, tagVerwaltungsstruktur, tagProzessmanagement, tagOrganisationsformen, tagVerwaltungsprozesse, tagVerwaltungsrecht, tagItRecht, tageGovernmentRecht, tagSelbstorganisation, tagTeamFaehigkeit, tagFuehrungskompentenzen, tagDesignThinking, tagStressbewaeltigung, tagKonfliktmanagement, tagMedienkompetenz, tagKommunikation, tagVirtuellesArbeiten, tagPraesentationstechnicken, tagLernkompetenzen, tagKundenbeduerfnisseAnforderungsmanagement, tagStakeholderAnalyse, tagDigitaleTrends, tagProgrammieren, tagSoftwarearchitektur, tagEntwicklungvonSicherheitskonzepten, tagBetirebssymsteme, tagErpSysteme, tagDataMining, tagDatenbankmanagement, tagKI, tagGrafikdesignBilbearbeitung, tagKollaborationstools, tagOutlook, tagWord, tagExcel, tagItSicherheit, tagHardwarekompetenz, tagBuergerzentrierung, tagDatenschutz, tagCompliance, tagFremdsprache, tagInformationsicherheit;
    private UserTag userTag1, userTag2, userTag3, userTag4;
    private Role OrganisationStratege, OrganisationEntscheidungsträger, OrganisationUmsetzer, DigitalisierungStratege, DigitalisierungEntscheidungsträger, DigitalisierungUmsetzer, InformationstechnikStratege, InformationstechnikEntscheidungsträger, InformationstechnikUmsetzer, SmartCityStratege, SmartCityEntscheidungsTräger, SmartCityUmsetzer, NichtDigitalStratege, NichtDigitalEntscheidungsträger, NichtDigitalUmsetzer, PersonalStratege, PersonalEntscheidungsträger, PersonalUmsetzer;

    private List<Category> categories;
    private List<Tag> tags;


    public void init() {
        insertUser();
        //insertCategories();
        insertCourse();
        //insertTag();
        parseTags();
        addTagsToUsers();
        addTagsToCourses();
        addFeedbackToCourses();
        insertRoles();
    }

    public void insertUser(){
        String test = passwordEncoder.encode("test");

        user1 = new UserEntity();
        user1.setActivated(true);
        user1.setName("Julian Sibbing");
        user1.setEmail("juliansibbing@gmail.com");
        user1.setPassword(test);

        userRepository.save(user1);

        // User 2
        user2 = new UserEntity();
        user2.setActivated(true);
        user2.setName("Anna Mueller");
        user2.setEmail("anna.mueller@example.com");
        user2.setPassword(test);
        userRepository.save(user2);

// User 3
        user3 = new UserEntity();
        user3.setActivated(true);
        user3.setName("Maximilian Wagner");
        user3.setEmail("maximilian.wagner@example.com");
        user3.setPassword(test);
        userRepository.save(user3);

        // User 4
        user4 = new UserEntity();
        user4.setActivated(true);
        user4.setName("Sophie Fischer");
        user4.setEmail("sophie.fischer@example.com");
        user4.setPassword(test);
        userRepository.save(user4);

// User 5
        user5 = new UserEntity();
        user5.setActivated(true);
        user5.setName("Alexander Schulz");
        user5.setEmail("alexander.schulz@example.com");
        user5.setPassword(test);
        userRepository.save(user5);

// User 6
        user6 = new UserEntity();
        user6.setActivated(true);
        user6.setName("Lena Becker");
        user6.setEmail("lena.becker@example.com");
        user6.setPassword(test);
        userRepository.save(user6);

// User 7
        user7 = new UserEntity();
        user7.setActivated(true);
        user7.setName("Nico Keller");
        user7.setEmail("nico.keller@example.com");
        user7.setPassword(test);
        userRepository.save(user7);

// User 8
        user8 = new UserEntity();
        user8.setActivated(true);
        user8.setName("Hannah Schmitt");
        user8.setEmail("hannah.schmitt@example.com");
        user8.setPassword(test);
        userRepository.save(user8);

// User 9
        user9 = new UserEntity();
        user9.setActivated(true);
        user9.setName("Finn Braun");
        user9.setEmail("finn.braun@example.com");
        user9.setPassword(test);
        userRepository.save(user9);

// User 10
        user10 = new UserEntity();
        user10.setActivated(true);
        user10.setName("Elena Keller");
        user10.setEmail("elena.keller@example.com");
        user10.setPassword(test);
        userRepository.save(user10);

        user11 = new UserEntity();
        user11.setActivated(true);
        user11.setName("Fabian");
        user11.setEmail("fuhlit@uni-muenster.de");
        user11.setPassword(test);
        userRepository.save(user11);

    }


    //feddig
    private void insertCategories() {

// Business Category
        businessCategory = new Category();
        businessCategory.setName("Business");
        categoryRepository.save(businessCategory);

// Organisatorisch Category
        organisatorischCategory = new Category();
        organisatorischCategory.setName("Organisatorisch");
        categoryRepository.save(organisatorischCategory);

// Rechtlich Category
        RechtlichCategory = new Category();
        RechtlichCategory.setName("Rechtlich");
        categoryRepository.save(RechtlichCategory);

// Soft Skills Category
        softSkillsCategory = new Category();
        softSkillsCategory.setName("Soft Skills");
        categoryRepository.save(softSkillsCategory);

// Sozio-technisch Category
        sozioTechnischCategory = new Category();
        sozioTechnischCategory.setName("Sozio-technisch");
        categoryRepository.save(sozioTechnischCategory);


// Technisch Category
        technischCategory = new Category();
        technischCategory.setName("Technisch");
        categoryRepository.save(technischCategory);

// oeffentlich/Politisch Category
        oeffenlichPolitischCategory = new Category();
        oeffenlichPolitischCategory.setName("Öffentlich/Politisch");
        categoryRepository.save(oeffenlichPolitischCategory);
    }

    public void insertCourse(){
        // Course 1
        course1 = new Course();
        course1.setCreator(this.getUser1());
        course1.setStartDate(new Date());
        course1.setLink("");
        course1.setName("Scrum für den öffentlichen Dienst");
        course1.setDescription("Ein Kurs, der grundlegende Prinzipien von Scrum für Mitarbeiter im öffentlichen Dienst vermittelt.");
        course1.setProvider("Digitale Bildungsinstitute GmbH");
        course1.setImage("https://www.ntaskmanager.com/wp-content/uploads/2019/08/Scrum-process-featured-image.jpg"); //erl
        course1.setDurationInMinutes(120);
        course1.setSkilllevel(Skilllevel.Anfaenger);
        course1.setFormat(Format.Hybrid);
        course1.setDomainSpecific(true);
        course1.setCostFree(true);
        course1.setCertificate(true);

        courseRepository.save(course1);

        // Course 2
        course2 = new Course();
        course2.setCreator(user2);
        course2.setStartDate(new Date());
        course2.setLink("");
        course2.setName("Einführung in Projektmanagement");
        course2.setDescription("Grundlegende Einführung in die Prinzipien und Methoden des Projektmanagements.");
        course2.setProvider("Projektakademie GmbH");
        course2.setImage("https://static.vecteezy.com/ti/gratis-vektor/p1/13166712-projektmanagement-wortkonzepte-blaue-fahne-strategie-infografiken-mit-bearbeitbaren-symbolen-auf-farbigem-hintergrund-isolierte-typografieillustration-mit-text-vektor.jpg"); //passt
        course2.setDurationInMinutes(180);
        course2.setSkilllevel(Skilllevel.Anfaenger);
        course2.setFormat(Format.OnlineSelbstorganisiert);
        course2.setDomainSpecific(false);
        course2.setCostFree(false);
        course2.setCertificate(true);

        courseRepository.save(course2);

// Course 3
        course3 = new Course();
        course3.setCreator(user3);
        course3.setStartDate(new Date());
        course3.setLink("");
        course3.setName("IT-Sicherheit fuer Einsteiger");
        course3.setDescription("Grundlagen der IT-Sicherheit fuer Anfänger, um sich vor Cyberbedrohungen zu schützen.");
        course3.setProvider("IT Security Academy");
        course3.setImage("https://www.netaachen.de/cms/api/fileadmin/_processed_/2/4/csm_Cyber_Security_AdobeStock_493619792_f222ca18f8.jpg"); //passt
        course3.setDurationInMinutes(150);
        course3.setSkilllevel(Skilllevel.Anfaenger);
        course3.setFormat(Format.Hybrid);
        course3.setDomainSpecific(false);
        course3.setCostFree(true);
        course3.setCertificate(true);

        courseRepository.save(course3);

// Course 4
        course4 = new Course();
        course4.setCreator(user4);
        course4.setStartDate(new Date());
        course4.setLink("");
        course4.setName("Effektive Organisationsgestaltung");
        course4.setDescription("Strategien zur effektiven Gestaltung von Organisationen und administrativen Prozessen.");
        course4.setProvider("Organisationsberatung & Co.");
        course4.setImage("https://i.imgur.com/GIXX7m9.jpeg"); //gpt
        course4.setDurationInMinutes(240);
        course4.setSkilllevel(Skilllevel.Fortgeschritten);
        course4.setFormat(Format.OnlineLive);
        course4.setDomainSpecific(true);
        course4.setCostFree(true);
        course4.setCertificate(true);

        courseRepository.save(course4);

// Course 5
        course5 = new Course();
        course5.setCreator(user5);
        course5.setStartDate(new Date());
        course5.setLink("");
        course5.setName("Psychologie fuer Führungskraefte");
        course5.setDescription("Um erfolgreich zu führen, ist es wichtig, menschliche Verhaltensmuster zu verstehen. Denn diese spiegeln sich im unterschiedlichen Agieren und Reagieren Ihrer Mitarbeitenden wider. Sobald Sie diese Muster erkennen, koennen Sie einfacher damit umgehen.");
        course5.setProvider("Führungsinstitut GmbH");
        course5.setImage("https://w2.forschung-und-lehre.de/fileadmin/user_upload/Rubriken/Management/2021/4-21/Humble_Leadership_mauritius_images_11538516.jpg"); //passt
        course5.setDurationInMinutes(180);
        course5.setSkilllevel(Skilllevel.Fortgeschritten);
        course5.setFormat(Format.Hybrid);
        course5.setDomainSpecific(false);
        course5.setCostFree(true);
        course5.setCertificate(false);

        courseRepository.save(course5);

// Course 6
        course6 = new Course();
        course6.setCreator(user6);
        course6.setStartDate(new Date());
        course6.setLink("");
        course6.setName("Grundlagen des Verwaltungsrechts");
        course6.setDescription("Eine Einführung in die grundlegenden Aspekte des Verwaltungsrechts.");
        course6.setProvider("Juristisches Institut");
        course6.setImage("https://raeluebbert.de/wp-content/uploads/2019/12/verwaltungsrecht.jpg");
        course6.setDurationInMinutes(120);
        course6.setSkilllevel(Skilllevel.Anfaenger);
        course6.setFormat(Format.Praesenz);
        course6.setDomainSpecific(true);
        course6.setCostFree(true);
        course6.setCertificate(true);

        courseRepository.save(course6);

// Course 7
        course7 = new Course();
        course7.setCreator(user7);
        course7.setStartDate(new Date());
        course7.setLink("");
        course7.setName("Effektive Konfliktlösung und Verhandlungsführung");
        course7.setDescription("Techniken für effektive Konfliktlösung und Verhandlungsführung in verschiedenen Kontexten.");
        course7.setProvider("Institut für Konfliktmanagement");
        course7.setImage("https://web.arbeitsagentur.de/dropsolid-prod-media/prod/s3fs-public/styles/webp/public/2022-12/iStock-1277920767_2500px-2048x1448.jpg.webp");
        course7.setDurationInMinutes(150);
        course7.setSkilllevel(Skilllevel.Fortgeschritten);
        course7.setFormat(Format.Hybrid);
        course7.setDomainSpecific(false);
        course7.setCostFree(false);
        course7.setCertificate(true);

        courseRepository.save(course7);

// Course 8
        course8 = new Course();
        course8.setCreator(user8);
        course8.setStartDate(new Date());
        course8.setLink("");
        course8.setName("Kundenbedürfnisse im Überblick");
        course8.setDescription("Eine Übersicht über Grundlagen und Entwicklungen von Kundenbedürfnissen und Anforderungsmanagement.");
        course8.setProvider("Sozialwissenschaftliches Institut");
        course8.setImage("https://arbeitgeber.de/wp-content/uploads/2022/05/bda-arbeitgeber-agenda-thema_der_woche_zeitenwende_sozialpolitik-@adobestock_snyGGG-552x274px-2022_05_12.jpg");
        course8.setDurationInMinutes(150);
        course8.setSkilllevel(Skilllevel.Anfaenger);
        course8.setFormat(Format.OnlineSelbstorganisiert);
        course8.setDomainSpecific(false);
        course8.setCostFree(false);
        course8.setCertificate(false);


        courseRepository.save(course8);

// Course 9
        course9 = new Course();
        course9.setCreator(user9);
        course9.setStartDate(new Date());
        course9.setLink("");
        course9.setName("Kreatives Problemlösen");
        course9.setDescription("Methoden und Ansätze für kreatives Denken und Problemlösung.");
        course9.setProvider("Institut fuer Kreativität und Innovation");
        course9.setImage("https://media.licdn.com/dms/image/D5612AQF6u-JnD4hQDw/article-cover_image-shrink_720_1280/0/1684945759396?e=2147483647&v=beta&t=pCHczuaGsT7b8Z0i7sxBOfHVw3sQ9qIe-xD5rjiahts");
        course9.setDurationInMinutes(240);
        course9.setSkilllevel(Skilllevel.Fortgeschritten);
        course9.setFormat(Format.Hybrid);
        course9.setDomainSpecific(true);
        course9.setCostFree(true);
        course9.setCertificate(true);

        courseRepository.save(course9);

// Course 10
        course10 = new Course();
        course10.setCreator(user10);
        course10.setStartDate(new Date());
        course10.setLink("");
        course10.setName("Selbstmanagement und persönliche Effektivität");
        course10.setDescription("Strategien zur Selbstorganisation und Steigerung der persönlichen Effektivität.");
        course10.setProvider("Persönlichkeitsentwicklungsakademie");
        course10.setImage("https://www.regiomanager.de/wp-content/uploads/1995/08/regio-1908-s-selbstmanagement-2nd-part-2-adobestock-234602455.jpg");
        course10.setDurationInMinutes(180);
        course10.setSkilllevel(Skilllevel.Fortgeschritten);
        course10.setFormat(Format.OnlineLive);
        course10.setDomainSpecific(true);
        course10.setCostFree(false);
        course10.setCertificate(true);

        courseRepository.save(course10);

        // Course 11
        course11 = new Course();
        course11.setCreator(user1);
        course11.setStartDate(new Date());
        course11.setLink("");
        course11.setName("Finanzmanagement für Nicht-Finanzexperten");
        course11.setDescription("Grundlagen des Finanzmanagements für Fachkraefte ohne Finanzhintergrund.");
        course11.setProvider("Finanzakademie GmbH");
        course11.setImage("https://images.ctfassets.net/8dreszsahte7/OWZH7RItGd67u8K0cMwOL/b2f9308236e087f4973dc95af159f0ed/image_60.jpg");
        course11.setDurationInMinutes(150);
        course11.setSkilllevel(Skilllevel.Anfaenger);
        course11.setFormat(Format.Hybrid);
        course11.setDomainSpecific(false);
        course11.setCostFree(false);
        course11.setCertificate(true);

        courseRepository.save(course11);

// Course 12
        course12 = new Course();
        course12.setCreator(user2);
        course12.setStartDate(new Date());
        course12.setLink("");
        course12.setName("Enterprise Architecture: Grundlagen und Anwendungen");
        course12.setDescription("Eine Einführung in die Grundlagen und Anwendungen von Enterprise Architecture.");
        course12.setProvider("IT-Architektur Institut");
        course12.setImage("https://nolijconsulting.com/wp-content/uploads/2022/04/blogimg-nolij-insight-1.jpg");
        course12.setDurationInMinutes(180);
        course12.setSkilllevel(Skilllevel.Fortgeschritten);
        course12.setFormat(Format.OnlineLive);
        course12.setDomainSpecific(false);
        course12.setCostFree(false);
        course12.setCertificate(true);

        courseRepository.save(course12);

// Course 13
        course13 = new Course();
        course13.setCreator(user3);
        course13.setStartDate(new Date());
        course13.setLink("");
        course13.setName("Bürgerzentrierung verstehen und gestalten");
        course13.setDescription("Analyse und Gestaltung von Bürgerzentrierung und Entscheidungsfindung.");
        course13.setProvider("Institut fuer Politikwissenschaft");
        course13.setImage("https://www.kopernikus-projekte.de/lw_resource/datapool/systemfiles/agent/lw_articlesystem/245/live/image2_cropped/AdobeStock_434744303_%C2%A9VectorMine_-_stock.adobe.com.jpeg");
        course13.setDurationInMinutes(240);
        course13.setSkilllevel(Skilllevel.Fortgeschritten);
        course13.setFormat(Format.Hybrid);
        course13.setDomainSpecific(false);
        course13.setCostFree(false);
        course13.setCertificate(false);

        courseRepository.save(course13);

// Course 14
        course14 = new Course();
        course14.setCreator(user4);
        course14.setStartDate(new Date());
        course14.setLink("");
        course14.setName("Einführung in die Evaluation und Forschungsmethoden");
        course14.setDescription("Grundlagen der Evaluation und Forschungsmethoden in verschiedenen Kontexten.");
        course14.setProvider("Forschungsinstitut für Sozialwissenschaften");
        course14.setImage("https://www.fbzhl.fau.de/files/2017/12/evaluation.jpg");
        course14.setDurationInMinutes(180);
        course14.setSkilllevel(Skilllevel.Anfaenger);
        course14.setFormat(Format.OnlineSelbstorganisiert);
        course14.setDomainSpecific(false);
        course14.setCostFree(false);
        course14.setCertificate(false);
        courseRepository.save(course14);

// Course 15
        course15 = new Course();
        course15.setCreator(user5);
        course15.setStartDate(new Date());
        course15.setLink("");
        course15.setName("Erfolgreiche Führungskraefte: Strategien für Einflussnahme");
        course15.setDescription("Strategien und Praktiken für erfolgreiche Fuehrungskräfte zur effektiven Einflussnahme.");
        course15.setProvider("Fuehrungsinstitut GmbH");
        course15.setImage("https://www.chieflearningofficer.com/wp-content/uploads/2023/05/AdobeStock_509757335.jpeg");
        course15.setDurationInMinutes(240);
        course15.setSkilllevel(Skilllevel.Fortgeschritten);
        course15.setFormat(Format.Hybrid);
        course15.setDomainSpecific(false);
        course15.setCostFree(false);
        course15.setCertificate(true);

        courseRepository.save(course15);

// Course 16
        course16 = new Course();
        course16.setCreator(user5);
        course16.setStartDate(new Date());
        course16.setLink("");
        course16.setName("eGovernment-Recht");
        course16.setDescription("Einfuehrung in die Rechte und Pflichten bei eGovernment.");
        course16.setProvider("Institut für Politikwissenschaft");
        course16.setImage("https://cdn.thehagueacademy.com/2022/09/1079-2.jpg"); //erl
        course16.setDurationInMinutes(600);
        course16.setSkilllevel(Skilllevel.Anfaenger);
        course16.setFormat(Format.Hybrid);
        course16.setDomainSpecific(false);
        course16.setCostFree(true);
        course16.setCertificate(true);

        courseRepository.save(course16);

// Course 17
        course17 = new Course();
        course17.setCreator(user2);
        course17.setStartDate(new Date());
        course17.setLink("");
        course17.setName("Java: Grundlagen der Programmierung");
        course17.setDescription("Eine Einfuehrung in die Grundlagen und Anwendungen von Java.");
        course17.setProvider("IT-Architektur Institut");
        course17.setImage("https://i.computer-bild.de/imgs/1/4/1/1/8/4/8/5/Programmieren-lernen-d3ce4a72fd4ddbf6.jpg"); //neu
        course17.setDurationInMinutes(420);
        course17.setSkilllevel(Skilllevel.Anfaenger);
        course17.setFormat(Format.OnlineLive);
        course17.setDomainSpecific(false);
        course17.setCostFree(false);
        course17.setCertificate(true);

        courseRepository.save(course17);

// Course 18
        course18 = new Course();
        course18.setCreator(user2);
        course18.setStartDate(new Date());
        course18.setLink("");
        course18.setName("Selbstorganisation mit Hilfe von Outlook");
        course18.setDescription("Hilfe bei der Selbstorganisation mit Outlook.");
        course18.setProvider("Outlook Institut");
        course18.setImage("https://www.lernen.net/wp-content/uploads/2021/03/selbstorganisation-feature-shutterstock.jpg"); //neu
        course18.setDurationInMinutes(300);
        course18.setSkilllevel(Skilllevel.Anfaenger);
        course18.setFormat(Format.OnlineSelbstorganisiert);
        course18.setDomainSpecific(false);
        course18.setCostFree(false);
        course18.setCertificate(true);

        courseRepository.save(course18);

// Course 19
        course19 = new Course();
        course19.setCreator(user2);
        course19.setStartDate(new Date());
        course19.setLink("");
        course19.setName("Qualitätsmanagement");
        course19.setDescription("Sicherung der Kundenbedürfnise durch Qualitätssicherung.");
        course19.setProvider("Qualitäts GmbH");
        course19.setImage("https://www.e-kern.com/fileadmin/user_upload/Images_Allgemein/Slider/Qualitaetsmanagement.jpg"); //neu
        course19.setDurationInMinutes(300);
        course19.setSkilllevel(Skilllevel.Fortgeschritten);
        course19.setFormat(Format.OnlineSelbstorganisiert);
        course19.setDomainSpecific(false);
        course19.setCostFree(false);
        course19.setCertificate(true);

        courseRepository.save(course19);

// Course 20
        course20 = new Course();
        course20.setCreator(user2);
        course20.setStartDate(new Date());
        course20.setLink("");
        course20.setName("Risikomanagement");
        course20.setDescription("Wie plant man mit Risikofaktoren?");
        course20.setProvider("Institut fuer Risikoforschung");
        course20.setImage("https://moodalis.oncampus.de/files/moduledescriptions/ac909ca83bfdc7b369bb8a1bbd1012de/risikomanagement_info_des_gra_de.png");
        course20.setDurationInMinutes(300);
        course20.setSkilllevel(Skilllevel.Fortgeschritten);
        course20.setFormat(Format.OnlineSelbstorganisiert);
        course20.setDomainSpecific(false);
        course20.setCostFree(false);
        course20.setCertificate(true);

        courseRepository.save(course20);

// Course 21
        course21 = new Course();
        course21.setCreator(user2);
        course21.setStartDate(new Date());
        course21.setLink("");
        course21.setName("Teamführung");
        course21.setDescription("Der richtige Umgang mit Streit im Arbeitsteam");
        course21.setProvider("Streitschlichter GmbH");
        course21.setImage("https://www.kegon.de/fileadmin/_processed_/d/f/csm_Bild_Teil_4_-_Teamfuehrung_150d37a841.jpeg");
        course21.setDurationInMinutes(600);
        course21.setSkilllevel(Skilllevel.Fortgeschritten);
        course21.setFormat(Format.OnlineSelbstorganisiert);
        course21.setDomainSpecific(false);
        course21.setCostFree(false);
        course21.setCertificate(true);

        courseRepository.save(course21);

// Course 22
        course22 = new Course();
        course22.setCreator(user2);
        course22.setStartDate(new Date());
        course22.setLink("");
        course22.setName("Business Englisch");
        course22.setDescription("Englisch für Fortgeschrittene.");
        course22.setProvider("Streitschlichter GmbH");
        course22.setImage("https://nzlc.ac.nz/wp-content/uploads/2020/05/business-english-course-1.jpg"); //erl
        course22.setDurationInMinutes(600);
        course22.setSkilllevel(Skilllevel.Fortgeschritten);
        course22.setFormat(Format.OnlineSelbstorganisiert);
        course22.setDomainSpecific(false);
        course22.setCostFree(false);
        course22.setCertificate(true);

        courseRepository.save(course22);

// Course 23
        course23 = new Course();
        course23.setCreator(user2);
        course23.setStartDate(new Date());
        course23.setLink("");
        course23.setName("Compliance in der oeffentlichen Verwaltung");
        course23.setDescription("Compliance ist die betriebswirtschaftliche und rechtswissenschaftliche Umschreibung für die Regeltreue von Unternehmen.");
        course23.setProvider("Institut für Compliance");
        course23.setImage("https://pisutandpartners.com/wp-content/uploads/2020/06/AdobeStock_230858386.jpeg");
        course23.setDurationInMinutes(600);
        course23.setSkilllevel(Skilllevel.Anfaenger);
        course23.setFormat(Format.Praesenz);
        course23.setDomainSpecific(true);
        course23.setCostFree(false);
        course23.setCertificate(true);

        courseRepository.save(course23);

// Course 24
        course24 = new Course();
        course24.setCreator(user2);
        course24.setStartDate(new Date());
        course24.setLink("");
        course24.setName("Digitale Trends in der Arbeitswelt");
        course24.setDescription("Die digitalen Trends, wie Homeoffice für Einsteiger.");
        course24.setProvider("Institut für Compliance");
        course24.setImage("https://www.processmaker.com/wp-content/uploads/2020/12/23324.jpg");
        course24.setDurationInMinutes(600);
        course24.setSkilllevel(Skilllevel.Anfaenger);
        course24.setFormat(Format.OnlineLive);
        course24.setDomainSpecific(true);
        course24.setCostFree(false);
        course24.setCertificate(true);

        courseRepository.save(course24);

// Course 25
        course25 = new Course();
        course25.setCreator(user2);
        course25.setStartDate(new Date());
        course25.setLink("");
        course25.setName("Präsentationen richtig halten");
        course25.setDescription("Die besten Präsentationstechnicken, um Arbeitsergebnisse zu präsentieren.");
        course25.setProvider("Institut für Compliance");
        course25.setImage("https://image.capital.de/31040666/t/sf/v1/w1440/r0/-/praesentation-dpa-123905030-1-jpg.jpg");
        course25.setDurationInMinutes(600);
        course25.setSkilllevel(Skilllevel.Anfaenger);
        course25.setFormat(Format.OnlineLive);
        course25.setDomainSpecific(true);
        course25.setCostFree(false);
        course25.setCertificate(true);

        courseRepository.save(course25);

// Course 26
        course26 = new Course();
        course26.setCreator(user2);
        course26.setStartDate(new Date());
        course26.setLink("");
        course26.setName("Datenschutz im Umgang mit KI");
        course26.setDescription("Wie dürfen KIs eigesetzt werden und wie können Daten dabei geschützt werden.");
        course26.setProvider("Uni Münster");
        course26.setImage("https://balthasar-legal.ch/wp-content/uploads/2021/09/KI-scaled.jpg");
        course26.setDurationInMinutes(600);
        course26.setSkilllevel(Skilllevel.Experte);
        course26.setFormat(Format.Praesenz);
        course26.setDomainSpecific(true);
        course26.setCostFree(false);
        course26.setCertificate(true);

        courseRepository.save(course26);


    }

    //neu
    public void parseTags(){
        JsonObject jsonObject = new JsonObject();
        try {
            InputStream file = new ClassPathResource("tags.json").getInputStream();
            String content = new String(file.readAllBytes());
            jsonObject = new Gson().fromJson(content, JsonObject.class);
        } catch(Exception e){
            e.printStackTrace();
        }
        //System.out.println(jsonObject);
        Map<String, Object> attributes = new HashMap<String, Object>();
        Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
        for(Map.Entry<String, JsonElement> entry : entrySet){
            String key = entry.getKey();
            List<JsonElement> tags = entry.getValue().getAsJsonArray().asList();

            Category category = new Category();
            category.setName(key);
            categoryRepository.save(category);

            for(JsonElement tagStr : tags){
                Tag tag = new Tag();
                tag.setName(tagStr.getAsString());
                tag.setCategory(category);
                tagRepository.save(tag);
            }
        }

    }

    //feddig
    public void insertTag(){

// Business Category
        tagChangemanagement = new Tag();
        tagChangemanagement.setName("Change Management");
        tagChangemanagement.setCategory(businessCategory);
        tagRepository.save(tagChangemanagement);

        tagProjektmanagement = new Tag();
        tagProjektmanagement.setName("Projekt Management");
        tagProjektmanagement.setCategory(businessCategory);
        tagRepository.save(tagProjektmanagement);

        tagProjektplanung = new Tag();
        tagProjektplanung.setName("Projektplanung");
        tagProjektplanung.setCategory(businessCategory);
        tagRepository.save(tagProjektplanung);

        tagProjekterfolgskontrolle = new Tag();
        tagProjekterfolgskontrolle.setName("Projekterfolgskontrolle");
        tagProjekterfolgskontrolle.setCategory(businessCategory);
        tagRepository.save(tagProjekterfolgskontrolle);

        tagResourcenmanagement = new Tag();
        tagResourcenmanagement.setName("Resourcenmanagement");
        tagResourcenmanagement.setCategory(businessCategory);
        tagRepository.save( tagResourcenmanagement);

        tagMarketing = new Tag();
        tagMarketing.setName("(Online-)Marketing");
        tagMarketing.setCategory(businessCategory);
        tagRepository.save(tagMarketing);

        tagQulitaetsmanagement = new Tag();
        tagQulitaetsmanagement.setName("Qulitätsmanagement");
        tagQulitaetsmanagement.setCategory(businessCategory);
        tagRepository.save(tagQulitaetsmanagement);

        tagRisikomanagement = new Tag();
        tagRisikomanagement.setName("Risikomanagement");
        tagRisikomanagement.setCategory(businessCategory);
        tagRepository.save(tagRisikomanagement);

// Organisatorisch Category
        tagVerwaltungsstruktur = new Tag();
        tagVerwaltungsstruktur.setName("Verwaltungsstruktur");
        tagVerwaltungsstruktur.setCategory(organisatorischCategory);
        tagRepository.save(tagVerwaltungsstruktur);

        tagProzessmanagement = new Tag();
        tagProzessmanagement.setName("Prozessmanagement");
        tagProzessmanagement.setCategory(organisatorischCategory);
        tagRepository.save(tagProzessmanagement);

        tagOrganisationsformen = new Tag();
        tagOrganisationsformen.setName("Organisationsformen");
        tagOrganisationsformen.setCategory(organisatorischCategory);
        tagRepository.save(tagOrganisationsformen);

        tagVerwaltungsprozesse = new Tag();
        tagVerwaltungsprozesse.setName("Verwaltungsprozesse");
        tagVerwaltungsprozesse.setCategory(organisatorischCategory);
        tagRepository.save(tagVerwaltungsprozesse);

// Rechtlich Category
        tagVerwaltungsrecht = new Tag();
        tagVerwaltungsrecht.setName("Verwaltungsrecht");
        tagVerwaltungsrecht.setCategory(RechtlichCategory);
        tagRepository.save(tagVerwaltungsrecht);

        tagItRecht = new Tag();
        tagItRecht.setName("IT-Recht");
        tagItRecht.setCategory(RechtlichCategory);
        tagRepository.save(tagItRecht);

        tageGovernmentRecht = new Tag();
        tageGovernmentRecht.setName("eGovernment-Recht");
        tageGovernmentRecht.setCategory(RechtlichCategory);
        tagRepository.save(tageGovernmentRecht);

// Softskills Category
        tagSelbstorganisation = new Tag();
        tagSelbstorganisation.setName("Selbstorganisation");
        tagSelbstorganisation.setCategory(softSkillsCategory);
        tagRepository.save(tagSelbstorganisation);

        tagTeamFaehigkeit = new Tag();
        tagTeamFaehigkeit.setName("Teamfähigkeit");
        tagTeamFaehigkeit.setCategory(softSkillsCategory);
        tagRepository.save(tagTeamFaehigkeit);

        tagFuehrungskompentenzen = new Tag();
        tagFuehrungskompentenzen.setName("Führungskompetenz");
        tagFuehrungskompentenzen.setCategory(softSkillsCategory);
        tagRepository.save(tagFuehrungskompentenzen);

        tagDesignThinking = new Tag();
        tagDesignThinking.setName("Design Thinking");
        tagDesignThinking.setCategory(softSkillsCategory);
        tagRepository.save(tagDesignThinking);

        tagStressbewaeltigung = new Tag();
        tagStressbewaeltigung.setName("Stressbewältigung");
        tagStressbewaeltigung.setCategory(softSkillsCategory);
        tagRepository.save(tagStressbewaeltigung);

        tagKonfliktmanagement = new Tag();
        tagKonfliktmanagement.setName("Konfliktmanagement");
        tagKonfliktmanagement.setCategory(softSkillsCategory);
        tagRepository.save(tagKonfliktmanagement);

        tagMedienkompetenz = new Tag();
        tagMedienkompetenz.setName("Medienkompetenz");
        tagMedienkompetenz.setCategory(softSkillsCategory);
        tagRepository.save(tagMedienkompetenz);

        tagKommunikation = new Tag();
        tagKommunikation.setName("Kommunikation");
        tagKommunikation.setCategory(softSkillsCategory);
        tagRepository.save(tagKommunikation);

        tagVirtuellesArbeiten = new Tag();
        tagVirtuellesArbeiten.setName("Virtuelles Arbeiten");
        tagVirtuellesArbeiten.setCategory(softSkillsCategory);
        tagRepository.save(tagVirtuellesArbeiten);

        tagPraesentationstechnicken = new Tag();
        tagPraesentationstechnicken.setName("Präsentationstechnicken");
        tagPraesentationstechnicken.setCategory(softSkillsCategory);
        tagRepository.save(tagPraesentationstechnicken);

        tagLernkompetenzen = new Tag();
        tagLernkompetenzen.setName("Lernkompetenz");
        tagLernkompetenzen.setCategory(softSkillsCategory);
        tagRepository.save(tagLernkompetenzen);

        tagVerwaltungsstruktur = new Tag();
        tagVerwaltungsstruktur.setName("Vermittlungskompetenz");
        tagVerwaltungsstruktur.setCategory(softSkillsCategory);
        tagRepository.save(tagVerwaltungsstruktur);


// Sozio-technisch Category
        tagKundenbeduerfnisseAnforderungsmanagement = new Tag();
        tagKundenbeduerfnisseAnforderungsmanagement.setName("Kundenbedürfnisse/ Anforderungsmanagement");
        tagKundenbeduerfnisseAnforderungsmanagement.setCategory(sozioTechnischCategory);
        tagRepository.save(tagKundenbeduerfnisseAnforderungsmanagement);

        tagStakeholderAnalyse = new Tag();
        tagStakeholderAnalyse.setName("Stakeholder-Analysen");
        tagStakeholderAnalyse.setCategory(sozioTechnischCategory);
        tagRepository.save(tagStakeholderAnalyse);

        tagDigitaleTrends = new Tag();
        tagDigitaleTrends.setName("Digitale Trends");
        tagDigitaleTrends.setCategory(sozioTechnischCategory);
        tagRepository.save(tagDigitaleTrends);

// Technisch Category
        tagProgrammieren = new Tag();
        tagProgrammieren.setName("Programmierung");
        tagProgrammieren.setCategory(technischCategory);
        tagRepository.save(tagProgrammieren);

        tagSoftwarearchitektur = new Tag();
        tagSoftwarearchitektur.setName("Softwarearchitektur");
        tagSoftwarearchitektur.setCategory(technischCategory);
        tagRepository.save(tagSoftwarearchitektur);

        tagEntwicklungvonSicherheitskonzepten = new Tag();
        tagEntwicklungvonSicherheitskonzepten.setName("Entwicklungs von Sicherheitskonzepten");
        tagEntwicklungvonSicherheitskonzepten.setCategory(technischCategory);
        tagRepository.save(tagEntwicklungvonSicherheitskonzepten);

        tagBetirebssymsteme = new Tag();
        tagBetirebssymsteme.setName("Betriebssysteme");
        tagBetirebssymsteme.setCategory(technischCategory);
        tagRepository.save(tagBetirebssymsteme);

        tagErpSysteme = new Tag();
        tagErpSysteme.setName("ERP-Systeme");
        tagErpSysteme.setCategory(technischCategory);
        tagRepository.save(tagErpSysteme);

        tagDataMining = new Tag();
        tagDataMining.setName("Data Mining");
        tagDataMining.setCategory(technischCategory);
        tagRepository.save(tagDataMining);

        tagDatenbankmanagement = new Tag();
        tagDatenbankmanagement.setName("Datenbankmanagement");
        tagDatenbankmanagement.setCategory(technischCategory);
        tagRepository.save(tagDatenbankmanagement);

        tagKI = new Tag();
        tagKI.setName("KI");
        tagKI.setCategory(technischCategory);
        tagRepository.save(tagKI);

        tagGrafikdesignBilbearbeitung = new Tag();
        tagGrafikdesignBilbearbeitung.setName("Grafikdesign & Bildbearbeitung");
        tagGrafikdesignBilbearbeitung.setCategory(technischCategory);
        tagRepository.save(tagGrafikdesignBilbearbeitung);

        tagKollaborationstools = new Tag();
        tagKollaborationstools.setName("Kollaborations-Tools");
        tagKollaborationstools.setCategory(technischCategory);
        tagRepository.save(tagKollaborationstools);

        tagOutlook = new Tag();
        tagOutlook.setName("Outlook");
        tagOutlook.setCategory(technischCategory);
        tagRepository.save(tagOutlook);

        tagWord = new Tag();
        tagWord.setName("Word");
        tagWord.setCategory(technischCategory);
        tagRepository.save(tagWord);

        tagExcel = new Tag();
        tagExcel.setName("Excel");
        tagExcel.setCategory(technischCategory);
        tagRepository.save(tagExcel);

        tagItSicherheit = new Tag();
        tagItSicherheit.setName("It-Sicherheit");
        tagItSicherheit.setCategory(technischCategory);
        tagRepository.save(tagItSicherheit);

        tagHardwarekompetenz = new Tag();
        tagHardwarekompetenz.setName("Hardwarekompetenz");
        tagHardwarekompetenz.setCategory(technischCategory);
        tagRepository.save(tagHardwarekompetenz);

// oeffentlich / Politisch Category
        tagBuergerzentrierung = new Tag();
        tagBuergerzentrierung.setName("Bürgerzentrierung");
        tagBuergerzentrierung.setCategory(oeffenlichPolitischCategory);
        tagRepository.save(tagBuergerzentrierung);

        tagDatenschutz = new Tag();
        tagDatenschutz.setName("Datenschutz");
        tagDatenschutz.setCategory(oeffenlichPolitischCategory);
        tagRepository.save(tagDatenschutz);

        tagCompliance = new Tag();
        tagCompliance.setName("Compliance");
        tagCompliance.setCategory(oeffenlichPolitischCategory);
        tagRepository.save(tagCompliance);

        tagFremdsprache = new Tag();
        tagFremdsprache.setName("Fremdsprache");
        tagFremdsprache.setCategory(oeffenlichPolitischCategory);
        tagRepository.save(tagFremdsprache);

        tagInformationsicherheit = new Tag();
        tagInformationsicherheit.setName("Informationssicherheit");
        tagInformationsicherheit.setCategory(oeffenlichPolitischCategory);
        tagRepository.save(tagInformationsicherheit);
    }

    //neu
    private void addTagsToUsers() {

        userTag1 = new UserTag();
        userTag1.setUser(user11);
        userTag1.setRating(1);
        userTag1.setTag(tagRepository.findByName("Design Thinking").orElse(null));

        userTagRepository.save(userTag1);

        userTag2 = new UserTag();
        userTag2.setUser(user11);
        userTag2.setRating(1);
        userTag2.setTag(tagRepository.findByName("Projektmanagement").orElse(null));

        userTagRepository.save(userTag2);

        userTag3 = new UserTag();
        userTag3.setUser(user11);
        userTag3.setRating(1);
        userTag3.setTag(tagRepository.findByName("Projektplanung").orElse(null));

        userTagRepository.save(userTag3);

        userTag4 = new UserTag();
        userTag4.setUser(user11);
        userTag4.setRating(1);
        userTag4.setTag(tagRepository.findByName("Teamfähigkeit").orElse(null));

        userTagRepository.save(userTag4);

    }

    private void addTagsToCourses() {

// Associate tags with Course 1
        CourseTag courseTagProjektPlanung1 = new CourseTag();
        courseTagProjektPlanung1.setCourse(course1);
        courseTagProjektPlanung1.setTag(tagRepository.findByName("Projektplanung").orElse(null));
        courseTagProjektPlanung1.setRating(1);
        courseTagRepository.save(courseTagProjektPlanung1);

        CourseTag courseTagOrganisationsformen1 = new CourseTag();
        courseTagOrganisationsformen1.setCourse(course1);
        courseTagOrganisationsformen1.setTag(tagRepository.findByName("Organisationsformen").orElse(null));
        courseTagOrganisationsformen1.setRating(1);
        courseTagRepository.save(courseTagOrganisationsformen1);

        CourseTag courseTagFuehrungskompetenz = new CourseTag();
        courseTagFuehrungskompetenz.setCourse(course1);
        courseTagFuehrungskompetenz.setTag(tagRepository.findByName("Führungskompetenz").orElse(null));
        courseTagFuehrungskompetenz.setRating(1);
        courseTagRepository.save(courseTagFuehrungskompetenz);

// Associate tags with Course 2
        CourseTag courseTagProjectManagement2 = new CourseTag();
        courseTagProjectManagement2.setCourse(course2);
        courseTagProjectManagement2.setTag(tagRepository.findByName("Projektmanagement").orElse(null));
        courseTagProjectManagement2.setRating(1);
        courseTagRepository.save(courseTagProjectManagement2);

        CourseTag courseTagFuehrungskompetenz2 = new CourseTag();
        courseTagFuehrungskompetenz2.setCourse(course2);
        courseTagFuehrungskompetenz2.setTag(tagRepository.findByName("Führungskompetenz").orElse(null));
        courseTagFuehrungskompetenz2.setRating(1);
        courseTagRepository.save(courseTagFuehrungskompetenz2);

// Associate tags with Course 3
        CourseTag courseTagItSicherheit3 = new CourseTag();
        courseTagItSicherheit3.setCourse(course3);
        courseTagItSicherheit3.setTag(tagRepository.findByName("It-Sicherheit").orElse(null));
        courseTagItSicherheit3.setRating(1);
        courseTagRepository.save(courseTagItSicherheit3);

        CourseTag courseTagDatenschutz3 = new CourseTag();
        courseTagDatenschutz3.setCourse(course3);
        courseTagDatenschutz3.setTag(tagRepository.findByName("Datenschutz").orElse(null));
        courseTagDatenschutz3.setRating(1);
        courseTagRepository.save(courseTagDatenschutz3);

// Associate tags with Course 4
        CourseTag courseTagOrganisationsformen4 = new CourseTag();
        courseTagOrganisationsformen4.setCourse(course4);
        courseTagOrganisationsformen4.setTag(tagRepository.findByName("Organisationsformen").orElse(null));
        courseTagOrganisationsformen4.setRating(1);
        courseTagRepository.save(courseTagOrganisationsformen4);

        CourseTag courseTagProzessmanagement4 = new CourseTag();
        courseTagProzessmanagement4.setCourse(course4);
        courseTagProzessmanagement4.setTag(tagRepository.findByName("Prozessmanagement").orElse(null));
        courseTagProzessmanagement4.setRating(1);
        courseTagRepository.save(courseTagProzessmanagement4);

        CourseTag courseTagFuehrungskompetenz4 = new CourseTag();
        courseTagFuehrungskompetenz4.setCourse(course4);
        courseTagFuehrungskompetenz4.setTag(tagRepository.findByName("Führungskompetenz").orElse(null));
        courseTagFuehrungskompetenz4.setRating(1);
        courseTagRepository.save(courseTagFuehrungskompetenz4);

// Associate tags with Course 5
        CourseTag courseTagFuehrungskompetenz5 = new CourseTag();
        courseTagFuehrungskompetenz5.setCourse(course5);
        courseTagFuehrungskompetenz5.setTag(tagRepository.findByName("Führungskompetenz").orElse(null));
        courseTagFuehrungskompetenz5.setRating(1);
        courseTagRepository.save(courseTagFuehrungskompetenz5);

        CourseTag courseTagKonfliktmanagement5 = new CourseTag();
        courseTagKonfliktmanagement5.setCourse(course5);
        courseTagKonfliktmanagement5.setTag(tagRepository.findByName("Konfliktmanagement").orElse(null));
        courseTagKonfliktmanagement5.setRating(1);
        courseTagRepository.save(courseTagKonfliktmanagement5);

        CourseTag courseTagKommunikation5 = new CourseTag();
        courseTagKommunikation5.setCourse(course5);
        courseTagKommunikation5.setTag(tagRepository.findByName("Kommunikation").orElse(null));
        courseTagFuehrungskompetenz4.setRating(1);
        courseTagRepository.save(courseTagKommunikation5);

// Associate tags with Course 6
        CourseTag courseTagVerwaltungsrecht6 = new CourseTag();
        courseTagVerwaltungsrecht6.setCourse(course6);
        courseTagVerwaltungsrecht6.setTag(tagRepository.findByName("Verwaltungsrecht").orElse(null));
        courseTagVerwaltungsrecht6.setRating(1);
        courseTagRepository.save(courseTagVerwaltungsrecht6);


// Associate tags with Course 7
        CourseTag courseTagKonfliktmanagement7 = new CourseTag();
        courseTagKonfliktmanagement7.setCourse(course7);
        courseTagKonfliktmanagement7.setTag(tagRepository.findByName("Konfliktmanagement").orElse(null));
        courseTagKonfliktmanagement7.setRating(1);
        courseTagRepository.save(courseTagKonfliktmanagement7);

        CourseTag coursetagVerwaltungsstruktur7 = new CourseTag();
        coursetagVerwaltungsstruktur7.setCourse(course7);
        coursetagVerwaltungsstruktur7.setTag(tagRepository.findByName("Verwaltungsstruktur").orElse(null));
        coursetagVerwaltungsstruktur7.setRating(1);
        courseTagRepository.save(coursetagVerwaltungsstruktur7);

// Associate tags with Course 8
        CourseTag courseTagKundenbeduerfnisse8 = new CourseTag();
        courseTagKundenbeduerfnisse8.setCourse(course8);
        courseTagKundenbeduerfnisse8.setTag(tagRepository.findByName("Kundenbedürfnisse/ Anforderungsmanagement").orElse(null));
        courseTagKundenbeduerfnisse8.setRating(1);
        courseTagRepository.save(courseTagKundenbeduerfnisse8);

        CourseTag courseTagKommunikation8 = new CourseTag();
        courseTagKommunikation8.setCourse(course8);
        courseTagKommunikation8.setTag(tagRepository.findByName("Kommunikation").orElse(null));
        courseTagKommunikation8.setRating(1);
        courseTagRepository.save(courseTagKommunikation8);

// Associate tags with Course 9
        CourseTag courseTagKonfliktmanagement9 = new CourseTag();
        courseTagKonfliktmanagement9.setCourse(course9);
        courseTagKonfliktmanagement9.setTag(tagRepository.findByName("Konfliktmanagement").orElse(null));
        courseTagKonfliktmanagement9.setRating(1);
        courseTagRepository.save(courseTagKonfliktmanagement9);

// Associate tags with Course 10
        CourseTag courseTagSelbstorganisation10 = new CourseTag();
        courseTagSelbstorganisation10.setCourse(course10);
        courseTagSelbstorganisation10.setTag(tagRepository.findByName("Selbstorganisation").orElse(null));
        courseTagSelbstorganisation10.setRating(1);
        courseTagRepository.save(courseTagSelbstorganisation10);

        CourseTag courseTagStessbewaeltigung10 = new CourseTag();
        courseTagStessbewaeltigung10.setCourse(course10);
        courseTagStessbewaeltigung10.setTag(tagRepository.findByName("Stressbewältigung").orElse(null));
        courseTagStessbewaeltigung10.setRating(1);
        courseTagRepository.save(courseTagStessbewaeltigung10);

// Associate tags with Course 11
        CourseTag courseTagRessourcenmanagement11 = new CourseTag();
        courseTagRessourcenmanagement11.setCourse(course11);
        courseTagRessourcenmanagement11.setTag(tagRepository.findByName("Resourcenmanagement").orElse(null));
        courseTagRessourcenmanagement11.setRating(1);
        courseTagRepository.save(courseTagRessourcenmanagement11);

        CourseTag courseTagVerwaltungsstruktur11 = new CourseTag();
        courseTagVerwaltungsstruktur11.setCourse(course11);
        courseTagVerwaltungsstruktur11.setTag(tagRepository.findByName("Verwaltungsstruktur").orElse(null));
        courseTagVerwaltungsstruktur11.setRating(1);
        courseTagRepository.save(courseTagVerwaltungsstruktur11);

// Associate tags with Course 12
        CourseTag courseTagSoftwarearchitektur12 = new CourseTag();
        courseTagSoftwarearchitektur12.setCourse(course12);
        courseTagSoftwarearchitektur12.setTag(tagRepository.findByName("Softwarearchitektur").orElse(null));
        courseTagSoftwarearchitektur12.setRating(1);
        courseTagRepository.save(courseTagSoftwarearchitektur12);

        CourseTag courseTagDatenbankmanagement12 = new CourseTag();
        courseTagDatenbankmanagement12.setCourse(course12);
        courseTagDatenbankmanagement12.setTag(tagRepository.findByName("Datenbankmanagement").orElse(null));
        courseTagDatenbankmanagement12.setRating(1);
        courseTagRepository.save(courseTagDatenbankmanagement12);

// Associate tags with Course 13
        CourseTag courseTagBuergerzentrierung = new CourseTag();
        courseTagBuergerzentrierung.setCourse(course13);
        courseTagBuergerzentrierung.setTag(tagRepository.findByName("Bürgerzentrierung").orElse(null));
        courseTagBuergerzentrierung.setRating(1);
        courseTagRepository.save(courseTagBuergerzentrierung);

        CourseTag courseTagVerwaltungsprozesse = new CourseTag();
        courseTagVerwaltungsprozesse.setCourse(course13);
        courseTagVerwaltungsprozesse.setTag(tagRepository.findByName("Verwaltungsprozesse").orElse(null));
        courseTagVerwaltungsprozesse.setRating(1);
        courseTagRepository.save(courseTagVerwaltungsprozesse);

// Associate tags with Course 14
        CourseTag courseTagLernkompetenzen14 = new CourseTag();
        courseTagLernkompetenzen14.setCourse(course14);
        courseTagLernkompetenzen14.setTag(tagRepository.findByName("Lernkompetenz").orElse(null));
        courseTagLernkompetenzen14.setRating(1);
        courseTagRepository.save(courseTagLernkompetenzen14);

        CourseTag courseTagInformationssicherheit14 = new CourseTag();
        courseTagInformationssicherheit14.setCourse(course14);
        courseTagInformationssicherheit14.setTag(tagRepository.findByName("Informationssicherheit").orElse(null));
        courseTagInformationssicherheit14.setRating(1);
        courseTagRepository.save(courseTagInformationssicherheit14);

// Associate tags with Course 15
        CourseTag courseTagfuehrungskompentenze15 = new CourseTag();
        courseTagfuehrungskompentenze15.setCourse(course15);
        courseTagfuehrungskompentenze15.setTag(tagRepository.findByName("Führungskompetenz").orElse(null));
        courseTagfuehrungskompentenze15.setRating(1);
        courseTagRepository.save(courseTagfuehrungskompentenze15);

        CourseTag coursetagVerwaltungsstruktur15 = new CourseTag();
        coursetagVerwaltungsstruktur15.setCourse(course15);
        coursetagVerwaltungsstruktur15.setTag(tagRepository.findByName("Verwaltungsstruktur").orElse(null));
        coursetagVerwaltungsstruktur15.setRating(1);
        courseTagRepository.save(coursetagVerwaltungsstruktur15);

// Associate tags with Course 16
        CourseTag courseTageGovernmentRecht = new CourseTag();
        courseTageGovernmentRecht.setCourse(course16);
        courseTageGovernmentRecht.setTag(tagRepository.findByName("eGovernment-Recht").orElse(null));
        courseTageGovernmentRecht.setRating(1);
        courseTagRepository.save(courseTageGovernmentRecht);

// Associate tags with Course 17
        CourseTag courseTagProgrammieren17 = new CourseTag();
        courseTagProgrammieren17.setCourse(course17);
        courseTagProgrammieren17.setTag(tagRepository.findByName("Programmierung").orElse(null));
        courseTagProgrammieren17.setRating(1);
        courseTagRepository.save(courseTagProgrammieren17);

// Associate tags with Course 18
        CourseTag courseTagSelbstorganisation18 = new CourseTag();
        courseTagSelbstorganisation18.setCourse(course18);
        courseTagSelbstorganisation18.setTag(tagRepository.findByName("Selbstorganisation").orElse(null));
        courseTagSelbstorganisation18.setRating(1);
        courseTagRepository.save(courseTagSelbstorganisation18);

        CourseTag courseTagOutlook18 = new CourseTag();
        courseTagOutlook18.setCourse(course18);
        courseTagOutlook18.setTag(tagRepository.findByName("Outlook").orElse(null));
        courseTagOutlook18.setRating(1);
        courseTagRepository.save(courseTagOutlook18);

// Associate tags with Course 19
        CourseTag courseTagQualitaetsmanagement19 = new CourseTag();
        courseTagQualitaetsmanagement19.setCourse(course19);
        courseTagQualitaetsmanagement19.setTag(tagRepository.findByName("Qualitätsmanagement").orElse(null));
        courseTagQualitaetsmanagement19.setRating(1);
        courseTagRepository.save(courseTagQualitaetsmanagement19);

        CourseTag courseTagKundenbeduerfnisse19 = new CourseTag();
        courseTagKundenbeduerfnisse19.setCourse(course19);
        courseTagKundenbeduerfnisse19.setTag(tagRepository.findByName("Kundenbedürfnisse/ Anforderungsmanagement").orElse(null));
        courseTagKundenbeduerfnisse19.setRating(1);
        courseTagRepository.save(courseTagKundenbeduerfnisse19);

// Associate tags with Course 20
        CourseTag courseTagRisikomanagement20 = new CourseTag();
        courseTagRisikomanagement20.setCourse(course20);
        courseTagRisikomanagement20.setTag(tagRepository.findByName("Qualitätsmanagement").orElse(null));
        courseTagRisikomanagement20.setRating(1);
        courseTagRepository.save(courseTagRisikomanagement20);

        CourseTag courseTagFuehrungskompetenz20 = new CourseTag();
        courseTagFuehrungskompetenz20.setCourse(course20);
        courseTagFuehrungskompetenz20.setTag(tagRepository.findByName("Führungskompetenz").orElse(null));
        courseTagFuehrungskompetenz20.setRating(1);
        courseTagRepository.save(courseTagFuehrungskompetenz20);

// Associate tags with Course 21
        CourseTag courseTagKonfliktmanagement21 = new CourseTag();
        courseTagKonfliktmanagement21.setCourse(course21);
        courseTagKonfliktmanagement21.setTag(tagRepository.findByName("Konfliktmanagement").orElse(null));
        courseTagKonfliktmanagement21.setRating(1);
        courseTagRepository.save(courseTagKonfliktmanagement21);

        CourseTag courseTagKommunikation21 = new CourseTag();
        courseTagKommunikation21.setCourse(course21);
        courseTagKommunikation21.setTag(tagRepository.findByName("Kommunikation").orElse(null));
        courseTagKommunikation21.setRating(1);
        courseTagRepository.save(courseTagKommunikation21);

        CourseTag courseTagFuehrungskometenz21 = new CourseTag();
        courseTagFuehrungskometenz21.setCourse(course21);
        courseTagFuehrungskometenz21.setTag(tagRepository.findByName("Führungskompetenz").orElse(null));
        courseTagFuehrungskometenz21.setRating(1);
        courseTagRepository.save(courseTagFuehrungskometenz21);

// Associate tags with Course 22
        CourseTag courseTagFremdsprachen22 = new CourseTag();
        courseTagFremdsprachen22.setCourse(course22);
        courseTagFremdsprachen22.setTag(tagRepository.findByName("Fremdsprache").orElse(null));
        courseTagFremdsprachen22.setRating(1);
        courseTagRepository.save(courseTagFremdsprachen22);

// Associate tags with Course 23
        CourseTag courseTagCompliance23 = new CourseTag();
        courseTagCompliance23.setCourse(course23);
        courseTagCompliance23.setTag(tagRepository.findByName("Compliance").orElse(null));
        courseTagCompliance23.setRating(1);
        courseTagRepository.save(courseTagCompliance23);

// Associate tags with Course 24
        CourseTag courseTagDigitaleTrends24 = new CourseTag();
        courseTagDigitaleTrends24.setCourse(course24);
        courseTagDigitaleTrends24.setTag(tagRepository.findByName("Digitales Arbeiten").orElse(null));
        courseTagDigitaleTrends24.setRating(1);
        courseTagRepository.save(courseTagDigitaleTrends24);

        CourseTag courseTagVirtuellesArbeiten = new CourseTag();
        courseTagVirtuellesArbeiten.setCourse(course24);
        courseTagVirtuellesArbeiten.setTag(tagRepository.findByName("Virtuelles Arbeiten").orElse(null));
        courseTagVirtuellesArbeiten.setRating(1);
        courseTagRepository.save(courseTagVirtuellesArbeiten);

// Associate tags with Course 25
        CourseTag courseTagPraesentationstechnicken25 = new CourseTag();
        courseTagPraesentationstechnicken25.setCourse(course25);
        courseTagPraesentationstechnicken25.setTag(tagRepository.findByName("Präsentationstechniken").orElse(null));
        courseTagPraesentationstechnicken25.setRating(1);
        courseTagRepository.save(courseTagPraesentationstechnicken25);

        CourseTag courseTagMedienkompetent25 = new CourseTag();
        courseTagMedienkompetent25.setCourse(course25);
        courseTagMedienkompetent25.setTag(tagRepository.findByName("Medienkompetenz").orElse(null));
        courseTagMedienkompetent25.setRating(1);
        courseTagRepository.save(courseTagMedienkompetent25);

// Associate tags with Course 26
        CourseTag courseTagDatenschutz26 = new CourseTag();
        courseTagDatenschutz26.setCourse(course26);
        courseTagDatenschutz26.setTag(tagRepository.findByName("Datenschutz").orElse(null));
        courseTagDatenschutz26.setRating(1);
        courseTagRepository.save(courseTagDatenschutz26);

        CourseTag courseTagKI26 = new CourseTag();
        courseTagKI26.setCourse(course26);
        courseTagKI26.setTag(tagRepository.findByName("KI").orElse(null));
        courseTagKI26.setRating(1);
        courseTagRepository.save(courseTagKI26);
    }

    private void addFeedbackToCourses() {
        // Feedback for Course 1
        Feedback feedback1Course1 = new Feedback();
        feedback1Course1.setCourse(course1);
        feedback1Course1.setUser(user1);
        feedback1Course1.setRating(5);
        feedback1Course1.setTitle("Super Kurs!");
        feedback1Course1.setDescription("Ich habe sehr viel gelernt und kann den Kurs nur weiterempfehlen.");
        feedback1Course1.setCreatedAt(new Date());
        course1.addFeedback(feedback1Course1);
        courseRepository.save(course1);

// Feedback for Course 2
        Feedback feedback1Course2 = new Feedback();
        feedback1Course2.setCourse(course2);
        feedback1Course2.setUser(user2);
        feedback1Course2.setRating(4);
        feedback1Course2.setTitle("Sehr informativ");
        feedback1Course2.setDescription("Der Kurs hat meine Erwartungen erfuellt und ich konnte mein Wissen im Projektmanagement erweitern.");
        feedback1Course2.setCreatedAt(new Date());
        course2.addFeedback(feedback1Course2);
        courseRepository.save(course2);

// Feedback for Course 3
        Feedback feedback1Course3 = new Feedback();
        feedback1Course3.setCourse(course3);
        feedback1Course3.setUser(user3);
        feedback1Course3.setRating(3);
        feedback1Course3.setTitle("Gut, aber verbesserungsfähig");
        feedback1Course3.setDescription("Der Kurs gibt einen guten Überblick ueber IT-Sicherheit, aber einige Themen könnten detaillierter behandelt werden.");
        feedback1Course3.setCreatedAt(new Date());
        course3.addFeedback(feedback1Course3);
        courseRepository.save(course3);

        // Feedback for Course 4
        Feedback feedback1Course4 = new Feedback();
        feedback1Course4.setCourse(course4);
        feedback1Course4.setUser(user4);
        feedback1Course4.setRating(4);
        feedback1Course4.setTitle("Interessanter Kurs");
        feedback1Course4.setDescription("Die Strategien zur effektiven Gestaltung von Organisationen waren sehr praxisnah und hilfreich.");
        feedback1Course4.setCreatedAt(new Date());
        course4.addFeedback(feedback1Course4);
        courseRepository.save(course4);

// Feedback for Course 5
        Feedback feedback1Course5 = new Feedback();
        feedback1Course5.setCourse(course5);
        feedback1Course5.setUser(user5);
        feedback1Course5.setRating(5);
        feedback1Course5.setTitle("Empfehlenswert!");
        feedback1Course5.setDescription("Sehr informative Einführung in die Grundkonzepte der öffentlichen Politik.");
        feedback1Course5.setCreatedAt(new Date());
        course5.addFeedback(feedback1Course5);
        courseRepository.save(course5);

// Feedback for Course 6
        Feedback feedback1Course6 = new Feedback();
        feedback1Course6.setCourse(course6);
        feedback1Course6.setUser(user6);
        feedback1Course6.setRating(3);
        feedback1Course6.setTitle("Solide Einführung");
        feedback1Course6.setDescription("Der Kurs bietet eine solide Einführung in die grundlegenden Aspekte des Verwaltungsrechts.");
        feedback1Course6.setCreatedAt(new Date());
        course6.addFeedback(feedback1Course6);
        courseRepository.save(course6);

// Feedback for Course 7
        Feedback feedback1Course7 = new Feedback();
        feedback1Course7.setCourse(course7);
        feedback1Course7.setUser(user7);
        feedback1Course7.setRating(4);
        feedback1Course7.setTitle("Effektive Techniken");
        feedback1Course7.setDescription("Die vorgestellten Techniken zur Konfliktlösung und Verhandlungsführung waren sehr praxisorientiert.");
        feedback1Course7.setCreatedAt(new Date());
        course7.addFeedback(feedback1Course7);
        courseRepository.save(course7);

// Feedback for Course 8
        Feedback feedback1Course8 = new Feedback();
        feedback1Course8.setCourse(course8);
        feedback1Course8.setUser(user8);
        feedback1Course8.setRating(3);
        feedback1Course8.setTitle("Guter Überblick");
        feedback1Course8.setDescription("Der Kurs bietet einen guten Überblick über Grundlagen und Entwicklungen in der Sozialpolitik.");
        feedback1Course8.setCreatedAt(new Date());
        course8.addFeedback(feedback1Course8);
        courseRepository.save(course8);

// Feedback for Course 9
        Feedback feedback1Course9 = new Feedback();
        feedback1Course9.setCourse(course9);
        feedback1Course9.setUser(user9);
        feedback1Course9.setRating(5);
        feedback1Course9.setTitle("Kreativität gefördert");
        feedback1Course9.setDescription("Der Kurs hat meine kreativen Denkprozesse angeregt und mir neue Loesungsansätze aufgezeigt.");
        feedback1Course9.setCreatedAt(new Date());
        course9.addFeedback(feedback1Course9);
        courseRepository.save(course9);

// Feedback for Course 10
        Feedback feedback1Course10 = new Feedback();
        feedback1Course10.setCourse(course10);
        feedback1Course10.setUser(user10);
        feedback1Course10.setRating(4);
        feedback1Course10.setTitle("Effektive Selbstmanagementstrategien");
        feedback1Course10.setDescription("Die vermittelten Strategien zur Selbstorganisation und persönlichen Effektivität sind sehr praktisch anwendbar.");
        feedback1Course10.setCreatedAt(new Date());
        course10.addFeedback(feedback1Course10);
        courseRepository.save(course10);

// Feedback for Course 11
        Feedback feedback1Course11 = new Feedback();
        feedback1Course11.setCourse(course11);
        feedback1Course11.setUser(user1);
        feedback1Course11.setRating(4);
        feedback1Course11.setTitle("Verständliche Finanzgrundlagen");
        feedback1Course11.setDescription("Der Kurs vermittelt Finanzgrundlagen verständlich und praxisnah.");
        feedback1Course11.setCreatedAt(new Date());
        course11.addFeedback(feedback1Course11);
        courseRepository.save(course11);

// Feedback for Course 12
        Feedback feedback1Course12 = new Feedback();
        feedback1Course12.setCourse(course12);
        feedback1Course12.setUser(user2);
        feedback1Course12.setRating(5);
        feedback1Course12.setTitle("Top-Einführung in Enterprise Architecture");
        feedback1Course12.setDescription("Sehr informative Einführung in die Grundlagen und Anwendungen von Enterprise Architecture.");
        feedback1Course12.setCreatedAt(new Date());
        course12.addFeedback(feedback1Course12);
        courseRepository.save(course12);

// Feedback for Course 13
        Feedback feedback1Course13 = new Feedback();
        feedback1Course13.setCourse(course13);
        feedback1Course13.setUser(user3);
        feedback1Course13.setRating(3);
        feedback1Course13.setTitle("Analytische Betrachtung");
        feedback1Course13.setDescription("Der Kurs bietet eine analytische Betrachtung von politischen Prozessen, könnte jedoch detaillierter sein.");
        feedback1Course13.setCreatedAt(new Date());
        course13.addFeedback(feedback1Course13);
        courseRepository.save(course13);

// Feedback for Course 14
        Feedback feedback1Course14 = new Feedback();
        feedback1Course14.setCourse(course14);
        feedback1Course14.setUser(user4);
        feedback1Course14.setRating(4);
        feedback1Course14.setTitle("Gute Einführung in Forschungsmethoden");
        feedback1Course14.setDescription("Der Kurs bietet eine gute Einführung in Evaluations- und Forschungsmethoden.");
        feedback1Course14.setCreatedAt(new Date());
        course14.addFeedback(feedback1Course14);
        courseRepository.save(course14);

// Feedback for Course 15
        Feedback feedback1Course15 = new Feedback();
        feedback1Course15.setCourse(course15);
        feedback1Course15.setUser(user5);
        feedback1Course15.setRating(5);
        feedback1Course15.setTitle("Effektive Fuehrungskräftestrategien");
        feedback1Course15.setDescription("Der Kurs vermittelt effektive Strategien für Fuehrungskräfte zur erfolgreichen Einflussnahme.");
        feedback1Course15.setCreatedAt(new Date());
        course15.addFeedback(feedback1Course15);
        courseRepository.save(course15);


    }

    //neu
    public void insertRoles(){
        List<Tag> alltags = tagRepository.findAllTags();
        //System.out.println(alltags);

        JsonArray roleJson = new JsonArray();
        JsonObject roleTags = new JsonObject();
        JsonObject vbTags = new JsonObject();

        try {
            InputStream roleJsonFile = new ClassPathResource("roles.json").getInputStream();
            String content = new String(roleJsonFile.readAllBytes());
            roleJson = new Gson().fromJson(content, JsonArray.class);

            InputStream roleTagsFile = new ClassPathResource("role_tags.json").getInputStream();
            String roleTagsContent = new String(roleTagsFile.readAllBytes());
            roleTags = new Gson().fromJson(roleTagsContent, JsonObject.class);

            InputStream vbTagsFile = new ClassPathResource("vb_tags.json").getInputStream();
            String vbTagsContent = new String(vbTagsFile.readAllBytes());
            vbTags = new Gson().fromJson(vbTagsContent, JsonObject.class);
        } catch(Exception e){
            e.printStackTrace();
        }

        for (JsonElement jsonElement : roleJson) {
            for(Verantwortungsbereich vb: Verantwortungsbereich.values()) {
                //create roles
                String roleName = jsonElement.getAsString();
                Role role = new Role();
                role.setName(roleName);
                role.setDescription("");
                role.setVerantwortungsbereich(vb);

                //add tags to roles according to role_tags.json
                JsonObject roleTagsObject = roleTags.getAsJsonObject(roleName);
                String [] advanced = {"normal", "advanced"};

                for(String level: advanced){
                    //System.out.println("level: " + level);
                    JsonArray roleTagsArray = roleTagsObject.getAsJsonArray(level);
                    //System.out.println("role: " + roleName + "roleTagsArray: " +roleTagsArray);
                    for (JsonElement roleTagElement : roleTagsArray) {
                        String tagName = roleTagElement.getAsString();
                        Tag tag = alltags.stream().filter(t -> t.getName().replace("\"", "").equals(tagName)).findFirst().orElse(null);
                        if(tag != null) {
                            RoleTag roleTag = new RoleTag();
                            roleTag.setTag(tag);
                            if(level.equals("advanced"))
                                roleTag.setRating(2);
                            else
                                roleTag.setRating(1);
                            roleTagRepository.save(roleTag);
                            role.addRoleTag(roleTag);
                        }
                        else {
                            System.out.println("tag not found: " + tagName);
                        }
                    }
                }

                //add tags to roles according to vb_tags.json
                JsonObject vbTagsObject = vbTags.getAsJsonObject(vb.toString());

                if(vbTagsObject != null)
                {
                    for(String level : advanced)
                    {
                        int levelInt = level.equals("normal") ? 1 : 2;
                        JsonArray vbTagsArray = vbTagsObject.getAsJsonArray(level);

                        for(JsonElement vbTagElement : vbTagsArray)
                        {
                            String tagName = vbTagElement.getAsString();
                            Tag tag = alltags.stream().filter(t -> t.getName().replace("\"", "").equals(tagName)).findFirst().orElse(null);
                            if(tag != null)
                            {
                                RoleTag roleTag = new RoleTag();
                                roleTag.setTag(tag);
                                roleTag.setRating(1);

                                RoleTag existing = roleTagRepository.getAllRoleTags().stream().filter(rt -> rt.getTag().getName().equals(tagName) && rt.getRating() == levelInt).findFirst().orElse(null);
                                if(existing == null)
                                    roleTagRepository.save(roleTag);
                                else
                                    roleTag = existing;

                                //if roletag already exists in role, don't add it again
                                if(role.getRoleTags().stream().filter(rt -> rt.getTag().getName().equals(tagName)).findFirst().orElse(null) == null)
                                    role.addRoleTag(roleTag);
                            } else
                            {
                                System.out.println("tag not found: " + tagName);
                            }
                        }
                    }
                }

                //add tags that should be added to all roles
                JsonArray vbTagsArray = vbTags.getAsJsonObject("Alle").getAsJsonArray("normal");
                for (JsonElement vbTagElement : vbTagsArray) {
                    String tagName = vbTagElement.getAsString();
                    Tag tag = alltags.stream().filter(t -> t.getName().replace("\"", "").equals(tagName)).findFirst().orElse(null);
                    if(tag != null) {
                        RoleTag roleTag = new RoleTag();
                        roleTag.setTag(tag);
                        roleTag.setRating(1);

                        RoleTag existing = roleTagRepository.getAllRoleTags().stream().filter(rt -> rt.getTag().getName().equals(tagName) && rt.getRating() == 1).findFirst().orElse(null);
                        if(existing == null)
                            roleTagRepository.save(roleTag);
                        else
                            roleTag = existing;

                        //if roletag already exists in role, don't add it again
                        if(role.getRoleTags().stream().filter(rt -> rt.getTag().getName().equals(tagName)).findFirst().orElse(null) == null)
                            role.addRoleTag(roleTag);
                    }
                    else {
                        System.out.println("tag not found: " + tagName);
                    }
                }

                roleRepository.save(role);
            }
        }

        /*
        OrganisationStratege = new Role();
        OrganisationStratege.setName("Organisation");
        OrganisationStratege.setDescription("");
        OrganisationStratege.setVerantwortungsbereich(Verantwortungsbereich.Stratege);
        roleRepository.save(OrganisationStratege);

        OrganisationEntscheidungsträger = new Role();
        OrganisationEntscheidungsträger.setName("Organisation");
        OrganisationEntscheidungsträger.setDescription("");
        OrganisationEntscheidungsträger.setVerantwortungsbereich(Verantwortungsbereich.Entscheidungsträger);
        roleRepository.save(OrganisationEntscheidungsträger);

        OrganisationUmsetzer = new Role();
        OrganisationUmsetzer.setName("Organisation");
        OrganisationUmsetzer.setDescription("");
        OrganisationUmsetzer.setVerantwortungsbereich(Verantwortungsbereich.Umsetzer);
        roleRepository.save(OrganisationUmsetzer);

        DigitalisierungStratege = new Role();
        DigitalisierungStratege.setName("Digitalisierung");
        DigitalisierungStratege.setDescription("");
        DigitalisierungStratege.setVerantwortungsbereich(Verantwortungsbereich.Stratege);
        roleRepository.save(DigitalisierungStratege);

        DigitalisierungEntscheidungsträger = new Role();
        DigitalisierungEntscheidungsträger.setName("Digitalisierung");
        DigitalisierungEntscheidungsträger.setDescription("");
        DigitalisierungEntscheidungsträger.setVerantwortungsbereich(Verantwortungsbereich.Entscheidungsträger);
        roleRepository.save(DigitalisierungEntscheidungsträger);

        DigitalisierungUmsetzer = new Role();
        DigitalisierungUmsetzer.setName("Digitalisierung");
        DigitalisierungUmsetzer.setDescription("");
        DigitalisierungUmsetzer.setVerantwortungsbereich(Verantwortungsbereich.Umsetzer);
        roleRepository.save(DigitalisierungUmsetzer);

        InformationstechnikStratege = new Role();
        InformationstechnikStratege.setName("Informationstechnik");
        InformationstechnikStratege.setDescription("");
        InformationstechnikStratege.setVerantwortungsbereich(Verantwortungsbereich.Stratege);
        roleRepository.save(InformationstechnikStratege);

        InformationstechnikEntscheidungsträger = new Role();
        InformationstechnikEntscheidungsträger.setName("Informationstechnik");
        InformationstechnikEntscheidungsträger.setDescription("");
        InformationstechnikEntscheidungsträger.setVerantwortungsbereich(Verantwortungsbereich.Entscheidungsträger);
        roleRepository.save(InformationstechnikEntscheidungsträger);

        InformationstechnikUmsetzer = new Role();
        InformationstechnikUmsetzer.setName("Informationstechnik");
        InformationstechnikUmsetzer.setDescription("");
        DigitalisierungUmsetzer.setVerantwortungsbereich(Verantwortungsbereich.Umsetzer);
        roleRepository.save(InformationstechnikUmsetzer);

        SmartCityStratege = new Role();
        SmartCityStratege.setName("Smart City");
        SmartCityStratege.setDescription("");
        SmartCityStratege.setVerantwortungsbereich(Verantwortungsbereich.Stratege);
        roleRepository.save(SmartCityStratege);

        SmartCityEntscheidungsTräger = new Role();
        SmartCityEntscheidungsTräger.setName("Smart City");
        SmartCityEntscheidungsTräger.setDescription("");
        SmartCityEntscheidungsTräger.setVerantwortungsbereich(Verantwortungsbereich.Entscheidungsträger);
        roleRepository.save(SmartCityEntscheidungsTräger);

        SmartCityUmsetzer = new Role();
        SmartCityUmsetzer.setName("Smart City");
        SmartCityUmsetzer.setDescription("");
        SmartCityUmsetzer.setVerantwortungsbereich(Verantwortungsbereich.Umsetzer);
        roleRepository.save(SmartCityUmsetzer);

        NichtDigitalStratege = new Role();
        NichtDigitalStratege.setName("Nicht-digital");
        NichtDigitalStratege.setDescription("");
        NichtDigitalStratege.setVerantwortungsbereich(Verantwortungsbereich.Stratege);
        roleRepository.save(NichtDigitalStratege);

        NichtDigitalEntscheidungsträger = new Role();
        NichtDigitalEntscheidungsträger.setName("Nicht-digital");
        NichtDigitalEntscheidungsträger.setDescription("");
        NichtDigitalEntscheidungsträger.setVerantwortungsbereich(Verantwortungsbereich.Entscheidungsträger);
        roleRepository.save(NichtDigitalEntscheidungsträger);

        NichtDigitalUmsetzer = new Role();
        NichtDigitalUmsetzer.setName("Nicht-digital");
        NichtDigitalUmsetzer.setDescription("");
        NichtDigitalUmsetzer.setVerantwortungsbereich(Verantwortungsbereich.Umsetzer);
        roleRepository.save(NichtDigitalUmsetzer);

        PersonalStratege = new Role();
        PersonalStratege.setName("Personal");
        PersonalStratege.setDescription("");
        PersonalStratege.setVerantwortungsbereich(Verantwortungsbereich.Stratege);
        roleRepository.save(PersonalStratege);

        PersonalEntscheidungsträger = new Role();
        PersonalEntscheidungsträger.setName("Personal");
        PersonalEntscheidungsträger.setDescription("");
        PersonalEntscheidungsträger.setVerantwortungsbereich(Verantwortungsbereich.Entscheidungsträger);
        roleRepository.save(PersonalEntscheidungsträger);

        PersonalUmsetzer = new Role();
        PersonalUmsetzer.setName("Personal");
        PersonalUmsetzer.setDescription("");
        PersonalUmsetzer.setVerantwortungsbereich(Verantwortungsbereich.Umsetzer);
        roleRepository.save(PersonalUmsetzer);

 */
    }
}
