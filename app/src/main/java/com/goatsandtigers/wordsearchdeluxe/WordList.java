package com.goatsandtigers.wordsearchdeluxe;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Arrays;
import java.util.List;

public enum WordList {

    AFRICAN_COUNTRIES("African Countries"),
    BERRIES("Berries"),
    BRITISH_TREES("British Trees"),
    CHESS_PIECES("Chess Pieces"),
    CONSTELLATIONS("Constellations"),
    DINOSAURS("Dinosaurs"),
    EGYPTIAN_GODS("Egyptian Gods"),
    EUROPEAN_CAPITALS("European Capitals"),
    GREEK_PHILOSOPHERS("Greek Philosophers"),
    PERIODIC_TABLE("Periodic Table"),
    RENAISSANCE_ARTISTS("Renaissance Artists"),
    SHEEP_BREEDS("Sheep breeds"),
    US_STATES("U.S. States"),
    WELSH_TOWNS("Welsh Towns");

    private static final String PREFS_NAME = "com.goatsandtigers.wordsearchdeluxe";
    private static final String CATEGORY_KEY = "category";

    private final String displayText;

    WordList(String displayText) {
        this.displayText = displayText;
    }

    public static List<String> loadWords(Context context) {
        WordList category = getCategory(context);
        if (category == AFRICAN_COUNTRIES) {
            return Arrays.asList("ALGERIA", "ANGOLA", "BENIN", "BOTSWANA", "BURUNDI", "CAMEROON", "CHAD", "COMOROS",
                    "DJIBOUTI", "EGYPT", "ERITREA", "ESWATINI", "ETHIOPIA", "GABON", "GAMBIA", "GHANA", "GUINEA", "KENYA",
                    "LESOTHO", "LIBERIA", "LIBYA", "MADAGASCAR", "MALAWI", "MALI", "MAURITANIA", "MAURITIUS", "MOROCCO",
                    "MOZAMBIQUE", "NAMIBIA", "NIGER", "NIGERIA", "RWANDA", "SENEGAL", "SEYCHELLES", "SOMALIA", "SUDAN",
                    "TANZANIA", "TOGO", "TUNISIA", "UGANDA", "ZAMBIA", "ZIMBABWE");
        } else if (category == BERRIES) {
            return Arrays.asList("ACAI", "AGARITA", "AMLA", "ARONIA", "BANEBERRY", "BARBERRY", "BEARBERRY", "BILBERRY", "BITTERSWEET",
                    "BLACKBERRY", "BLUEBERRY", "BOYSENBERRY", "BUNCHBERRY", "CAPERBERRY", "CLOUDBERRY", "COWBERRY", "CRANBERRY",
                    "CURRANT", "DEWBERRY", "ELDERBERRY", "FARKLEBERRY", "GOJI", "GOOSEBERRY", "GRAPE", "HACKBERRY", "HUCKLEBERRY",
                    "JUNEBERRY", "JUNIPER", "LINGONBERRY", "LOGANBERRY", "NANNYBERRY", "PERSIMMON", "POKEBERRY", "RASPBERRY", "SALMONBERRY",
                    "SEABERRY", "SNOWBERRY", "STRAWBERRY", "SUGARBERRY", "TAYBERRY", "THIMBLEBERRY", "WINTERGREEN", "YOUNGBERRY");
        } else if (category == BRITISH_TREES) {
            return Arrays.asList("ALDER", "APPLE", "ASH", "ASPEN", "BEECH", "BIRCH", "BLACKTHORN", "BOX", "BUCKTHORN", "CEDAR", "CHERRY",
                    "CHESTNUT", "CYPRESS", "DOGWOOD", "ELDER", "ELM", "EUCALYPTUS", "FIR", "HAZEL", "HEMLOCK", "HOLLY", "HORNBEAM", "JUNIPER",
                    "LIME", "MAPLE", "OAK", "PEAR", "PINE", "PLANE", "PLUM", "POPLAR", "ROWAN", "SPINDLE", "SPRUCE", "SYCAMORE",
                    "WALNUT", "WHITEBEAM", "WILLOW", "YEW");
        } else if (category == CHESS_PIECES) {
            return Arrays.asList("BISHOP", "KING", "KNIGHT", "PAWN", "QUEEN", "ROOK");
        } else if (category == CONSTELLATIONS) {
            return Arrays.asList("ANDROMEDA", "ANTLIA", "APUS", "AQUARIUS", "AQUILA", "ARA", "ARIES", "AURIGA", "CAELUM",
                    "CAMELOPARDALIS", "CANCER", "CAPRICORNUS", "CARINA", "CASSIOPEIA", "CENTAURUS", "CEPHEUS", "CETUS",
                    "CHAMAELEON", "CIRCINUS", "COLUMBA", "CORVUS", "CRATER", "CRUX", "CYGNUS", "DELPHINUS", "DORADO", "DRACO",
                    "EQUULEUS", "ERIDANUS", "FORNAX", "GEMINI", "GRUS", "HERCULES", "HOROLOGIUM", "HYDRA", "HYDRUS", "INDUS",
                    "LACERTA", "LEO", "LEPUS", "LIBRA", "LUPUS", "LYNX", "LYRA", "MENSA", "MICROSCOPIUM", "MONOCEROS", "MUSCA",
                    "NORMA", "OCTANS", "OPHIUCHUS", "ORION", "PAVO", "PEGASUS", "PERSEUS", "PHOENIX", "PICTOR", "PISCES",
                    "PUPPIS", "PYXIS", "RETICULUM", "SAGITTA", "SAGITTARIUS", "SCORPIUS", "SCULPTOR", "SCUTUM", "SERPENS",
                    "SEXTANS", "TAURUS", "TELESCOPIUM", "TRIANGULUM", "TUCANA", "VELA", "VIRGO", "VOLANS", "VULPECULA");
        } else if (category == DINOSAURS) {
            return Arrays.asList("AARDONYX", "ABELISAURUS", "ACHELOUSAURUS", "ACHILLOBATOR", "ACROCANTHOSAURUS",
                    "AEGYPTOSAURUS", "AFROVENATOR", "AGILISAURUS", "ALAMOSAURUS", "ALBERTACERATOPS", "ALBERTOSAURUS",
                    "ALECTROSAURUS", "ALIORAMUS", "ALLOSAURUS", "ALVAREZSAURUS", "AMARGASAURUS", "AMMOSAURUS", "AMPELOSAURUS",
                    "AMYGDALODON", "ANCHICERATOPS", "ANCHISAURUS", "ANKYLOSAURUS", "ANSERIMIMUS", "ANTARCTOSAURUS",
                    "APATOSAURUS", "ARAGOSAURUS", "ARALOSAURUS", "ARCHAEOCERATOPS", "ARCHAEOPTERYX", "ARGENTINOSAURUS",
                    "ARRHINOCERATOPS", "ATLASCOPCOSAURUS", "AUCASAURUS", "AUSTROSAURUS", "AVACERATOPS", "AVIMIMUS",
                    "BACTROSAURUS", "BAGACERATOPS", "BAMBIRAPTOR", "BARAPASAURUS", "BAROSAURUS", "BARYONYX", "BECKLESPINAX",
                    "BEIPIAOSAURUS", "BELLUSAURUS", "BOROGOVIA", "BRACHIOSAURUS", "BUITRERAPTOR", "CAMARASAURUS", "CAMPTOSAURUS",
                    "CARNOTAURUS", "CAUDIPTERYX", "CEDARPELTA", "CENTROSAURUS", "CERATOSAURUS", "CETIOSAURISCUS", "CETIOSAURUS",
                    "CHASMOSAURUS", "CHINDESAURUS", "CHIROSTENOTES", "CHUBUTISAURUS", "CITIPATI", "COELOPHYSIS", "COELURUS",
                    "COLORADISAURUS", "COMPSOGNATHUS", "CONCHORAPTOR", "CONFUCIUSORNIS", "CORYTHOSAURUS", "CRYOLOPHOSAURUS",
                    "DACENTRURUS", "DASPLETOSAURUS", "DATOUSAURUS", "DEINOCHEIRUS", "DEINONYCHUS", "DELTADROMEUS", "DICRAEOSAURUS",
                    "DILOPHOSAURUS", "DIPLODOCUS", "DROMAEOSAURUS", "DRYOSAURUS", "DRYPTOSAURUS", "EDMONTONIA", "EDMONTOSAURUS",
                    "EINIOSAURUS", "ELAPHROSAURUS", "EMAUSAURUS", "EOLAMBIA", "EORAPTOR", "EOTYRANNUS", "EQUIJUBUS", "ERKETU",
                    "ERLIKOSAURUS", "EUHELOPUS", "FUKUIRAPTOR", "FUKUISAURUS", "GALLIMIMUS", "GASTONIA", "GIGANOTOSAURUS",
                    "GILMOREOSAURUS", "GIRAFFATITAN", "GOBISAURUS", "GORGOSAURUS", "GOYOCEPHALE", "GRACILICERATOPS", "GRYPOSAURUS",
                    "GUAIBASAURUS", "GUANLONG", "HADROSAURUS", "HAGRYPHUS", "HARPYMIMUS", "HEYUANNIA", "HOMALOCEPHALE",
                    "HYLAEOSAURUS", "HYPACROSAURUS", "HYPSILOPHODON", "IGUANODON", "INDOSUCHUS", "JANENSCHIA ", "JAXARTOSAURUS",
                    "JOBARIA", "JURAVENATOR", "KENTROSAURUS", "KHAAN", "KOTASAURUS", "KRITOSAURUS", "LAMBEOSAURUS", "LEPTOCERATOPS",
                    "LESOTHOSAURUS", "LIAOCERATOPS", "LIGABUESAURUS", "LILIENSTERNUS", "LOPHORHOTHON", "LOPHOSTROPHEUS", "LUFENGOSAURUS",
                    "LURDUSAURUS", "LYCORHINUS", "MAGYAROSAURUS", "MAIASAURA", "MAJUNGASAURUS", "MAPUSAURUS", "MARSHOSAURUS", "MEGALOSAURUS",
                    "MELANOROSAURUS", "MICROCERATUS", "MICRORAPTOR", "MINMI", "MONONYKUS", "MUSSAURUS", "NEDOCERATOPS", "NEMEGTOSAURUS",
                    "NEOVENATOR", "NIGERSAURUS", "NOASAURUS", "NOMINGIA", "NOTHRONYCHUS", "OMEISAURUS", "ORNITHOLESTES", "ORNITHOMIMUS",
                    "ORODROMEUS", "ORYCTODROMEUS", "OTHNIELIA", "OVIRAPTOR", "PANTYDRACO", "PARALITITAN", "PARKSOSAURUS", "PATAGOSAURUS",
                    "PELICANIMIMUS", "PENTACERATOPS", "PLATEOSAURUS", "POLACANTHUS", "PRENOCEPHALE", "PROTOCERATOPS", "PROTOHADROS",
                    "PSITTACOSAURUS", "QUAESITOSAURUS", "REBBACHISAURUS", "RHABDODON", "RHOETOSAURUS", "RINCHENIA", "RIOJASAURUS", "RUGOPS",
                    "SAICHANIA", "SALTASAURUS", "SALTOPUS", "SARCOSAURUS", "SAUROLOPHUS", "SAUROPELTA", "SECERNOSAURUS", "SEGISAURUS",
                    "SEGNOSAURUS", "SHAMOSAURUS", "SHANAG", "SHUNOSAURUS", "SHUVUUIA", "SILVISAURUS", "SINOCALLIOPTERYX", "SINORNITHOSAURUS",
                    "SINOSAUROPTERYX", "SINOVENATOR", "SINRAPTOR", "SONIDOSAURUS", "SPINOSAURUS", "STAURIKOSAURUS", "STEGOCERAS", "STEGOSAURUS",
                    "STENOPELIX", "STRUTHIOMIMUS", "STRUTHIOSAURUS", "STYRACOSAURUS", "SUCHOMIMUS", "SUPERSAURUS", "TALARURUS", "TANIUS",
                    "TARBOSAURUS", "TARCHIA", "TELMATOSAURUS", "TORVOSAURUS", "TRICERATOPS", "TROODON", "TSAGANTEGIA", "TSINTAOSAURUS",
                    "TYLOCEPHALE", "TYRANNOSAURUS", "UDANOCERATOPS", "UNENLAGIA", "URBACODON", "UTAHRAPTOR", "VALDOSAURUS", "VELOCIRAPTOR",
                    "VULCANODON", "YANDUSAURUS", "YIMENOSAURUS", "YINLONG", "YUANMOUSAURUS", "ZALMOXES", "ZEPHYROSAURUS", "ZUNICERATOPS");
        } else if (category == EGYPTIAN_GODS) {
            return Arrays.asList("AKER", "AMUN", "ANHUR", "ATEN", "ATUM", "BENNU", "GEB", "HAPI", "HORUS", "KHEPRI",
                    "KHNUM", "KHONSU", "MAAHES", "MONTU", "NEFERTUM", "NEMTY", "NEPER", "OSIRIS", "PTAH", "RA", "SET",
                    "SHU", "SOBEK", "SOPDU", "THOTH");
        } else if (category == EUROPEAN_CAPITALS) {
            return Arrays.asList("AMSTERDAM", "ATHENS", "BAKU", "BELGRADE", "BERLIN", "BERN", "BRATISLAVA", "BRUSSELS", "BUCHAREST", "BUDAPEST", "CHISINAU",
                    "COPENHAGEN", "DUBLIN", "HELSINKI", "LISBON", "LJUBLJANA", "LONDON", "LUXEMBOURG", "MADRID", "MINSK", "NICOSIA", "OSLO", "PARIS",
                    "PODGORICA", "PRAGUE", "PRISTINA", "REYKJAVIK", "RIGA", "ROME", "SARAJEVO", "SKOPJE", "SOFIA", "STOCKHOLM", "TALLINN", "TBILISI",
                    "TIRANA", "VADUZ", "VALLETTA", "VIENNA", "VILNIUS", "WARSAW", "YEREVAN", "ZAGREB");
        } else if (category == GREEK_PHILOSOPHERS) {
            return Arrays.asList("ACRION", "AEDESIA", "AEDESIUS", "AENESIDEMUS", "AESARA", "AETIUS", "AGAPIUS", "AGATHOBULUS", "AGATHOSTHENES", "ALBINUS",
                    "ALCINOUS", "ALCIBIADES", "ALEXICRATES", "ALEXINUS", "AMELIUS", "ANAXAGORAS", "ANAXARCHUS", "ANAXILAUS", "ANAXIMANDER", "ANDROCYDES",
                    "ANNICERIS", "ANTISTHENES", "ANTONINUS", "ARCESILAUS", "ARCHELAUS", "ARCHYTAS", "ARIGNOTE", "ARISTIPPUS", "ARISTOCLEA", "ARISTOCREON",
                    "ARISTOTLE", "ARISTOXENUS", "ASCLEPIGENIA", "ASCLEPIODOTUS", "ASPASIUS", "ATTALUS", "ATTICUS", "BASILIDES", "BRONTINUS", "CALLICLES",
                    "CALLIPHON", "CALLISTRATUS", "CARNEADES", "CARNEISCUS", "CEBES", "CELSUS", "CERCIDAS", "CERCOPS", "CHAEREPHON", "CHAMAELEON", "CHARMADAS",
                    "CHRYSANTHIUS", "CHRYSIPPUS", "CLEANTHES", "CLEOMENES", "CLINOMACHUS", "CLITOMACHUS", "COLOTES", "CRANTOR", "CRATYLUS",
                    "CRINIS", "CRITOLAUS", "CRONIUS", "DAMASCIUS", "DAMIS", "DAMO", "DEMOCRATES", "DEMOCRITUS", "DEMONAX", "DEXIPPUS", "DICAEARCHUS", "DIODOTUS",
                    "DIOTIMUS", "ECHECRATES", "ECPHANTUS", "EMPEDOCLES", "EPICTETUS", "EPICURUS", "EUBULIDES", "EUENUS", "EUPHANTUS", "EUPHRAEUS", "EUPHRATES",
                    "EURYTUS", "EVANDER", "FAVORINUS", "GEMINUS", "GORGIAS", "HEGIAS", "HERACLITUS", "HERACLIUS", "HERMARCHUS", "HERMIAS", "HERMINUS",
                    "HICETAS", "HIERIUS", "HIEROCLES", "HIMERIUS", "HIPPASUS", "HIPPIAS", "HIPPO", "HORUS", "IAMBLICHUS", "ICHTHYAS", "LEONTION", "LEUCIPPUS",
                    "LYCOPHRON", "MENEDEMUS", "MENIPPUS", "METROCLES", "MONIMUS", "MYIA", "NAUSIPHANES", "NICOMACHUS", "ONASANDER", "ONATAS", "PANAETIUS",
                    "PANTHOIDES", "PERSAEUS", "PHAEDRUS", "PHILODEMUS", "PHILOLAUS", "PHILOSTRATUS", "PHINTYS", "PLATO", "PLOTINUS", "PLUTARCH", "POLEMARCHUS",
                    "POLEMON", "POLUS", "POLYSTRATUS", "PORPHYRY", "POSIDONIUS", "PRAXIPHANES", "PROCLUS", "PRODICUS", "PROTAGORAS", "PYRRHO", "PYTHAGORAS",
                    "SALLUSTIUS", "SATYRUS", "SIRO", "SOCRATES", "SOSIGENES", "SOSIPATRA", "SOTION", "SPEUSIPPUS", "SPHAERUS", "STILPO", "SYRIANUS", "TELAUGES",
                    "THALES", "THEANO", "THEMISTIUS", "THEOPHRASTUS", "THRASYMACHUS", "TIMON", "TIMYCHA", "TISIAS", "XENIADES", "XENOCRATES", "XENOPHILUS",
                    "XENOPHON", "ZENOBIUS", "ZENODOTUS");
        } else if (category == PERIODIC_TABLE) {
            return Arrays.asList("ACTINIUM", "ALUMINUM", "AMERICIUM", "ANTIMONY", "ARGON", "ARSENIC", "ASTATINE", "BARIUM", "BERKELIUM", "BERYLLIUM",
                    "BISMUTH", "BOHRIUM", "BORON", "BROMINE", "CADMIUM", "CALCIUM", "CALIFORNIUM", "CARBON", "CERIUM", "CESIUM",
                    "CHLORINE", "CHROMIUM", "COBALT", "COPERNICIUM", "COPPER", "CURIUM", "DARMSTADTIUM", "DUBNIUM", "DYSPROSIUM",
                    "EINSTEINIUM", "ERBIUM", "EUROPIUM", "FERMIUM", "FLEROVIUM", "FLUORINE", "FRANCIUM", "GADOLINIUM", "GALLIUM",
                    "GERMANIUM", "GOLD", "HAFNIUM", "HASSIUM", "HELIUM", "HOLMIUM", "HYDROGEN", "INDIUM", "IODINE", "IRIDIUM",
                    "IRON", "KRYPTON", "LANTHANUM", "LAWRENCIUM", "LEAD", "LITHIUM", "LIVERMORIUM", "LUTETIUM", "MAGNESIUM", "MANGANESE",
                    "MEITNERIUM", "MENDELEVIUM", "MERCURY", "MOLYBDENUM", "MOSCOVIUM", "NEODYMIUM", "NEON", "NEPTUNIUM", "NICKEL",
                    "NIHONIUM", "NIOBIUM", "NITROGEN", "NOBELIUM", "OGANESSON", "OSMIUM", "OXYGEN", "PALLADIUM", "PHOSPHORUS",
                    "PLATINUM", "PLUTONIUM", "POLONIUM", "POTASSIUM", "PRASEODYMIUM", "PROMETHIUM", "PROTACTINIUM", "RADIUM",
                    "RADON", "RHENIUM", "RHODIUM", "ROENTGENIUM", "RUBIDIUM", "RUTHENIUM", "RUTHERFORDIUM", "SAMARIUM", "SCANDIUM",
                    "SEABORGIUM", "SELENIUM", "SILICON", "SILVER", "SODIUM", "STRONTIUM", "SULFUR", "TANTALUM", "TECHNETIUM",
                    "TELLURIUM", "TENNESSINE", "TERBIUM", "THALLIUM", "THORIUM", "THULIUM", "TIN", "TITANIUM", "TUNGSTEN", "URANIUM",
                    "VANADIUM", "XENON", "YTTERBIUM", "YTTRIUM", "ZINC", "ZIRCONIUM");
        } else if (category == RENAISSANCE_ARTISTS) {
            return Arrays.asList("ALBERTINELLI", "ANGELICO", "BALDOVINETTI", "BASSANO", "BASTIANI", "BELLINI", "BERRUGUETE", "BOTTICELLI",
                    "CAMPI", "CAMBIASO", "COZZARELLI", "DADDI", "DONATELLO", "DOSSI", "FOUQUET", "FRANCIA", "GOZZOLI", "LIGOZZI", "LORENZETTI",
                    "MICHELANGELO", "MEMMI", "ORCAGNA", "RAPHAEL", "SASSETTA", "TINTORETTO", "TITIAN", "UCCELLO", "VENEZIANO");
        } else if (category == SHEEP_BREEDS) {
            return Arrays.asList("ACIPAYAM", "ADAL", "AFRICANA", "AFRIKANER", "AFRINO", "ALAI", "ALTAY", "ANCON", "APPENNINICA",
                    "ARABI", "ARAPAWA", "ASKANIAN", "ASSAF", "AUSSIEDOWN", "AWASSI", "BANNUR", "BALKHI", "BALUCHI", "BARDOKA",
                    "BELTEX", "BERGAMASCA", "BIBRIK", "BIELLESE", "BIZET", "BOND", "BORERAY", "CHARMOISE", "CHAROLLAIS", "CHEVIOT",
                    "CHIOS", "CHOLISTANI", "CHURRA", "CIGAJA", "CIKTA", "COLUMBIA", "COMEBACK", "COMISANA", "COOLALEE", "COOPWORTH",
                    "CORMO", "CORRIEDALE", "COTSWOLD", "CRIOLLO", "DALESBRED",  "DAMANI", "DAMARA", "DEBOUILLET", "DORPER",
                    "DORSET", "DRYSDALE", "EASYCARE", "EDILBAY", "ELLIOTTDALE", "FABRIANESE", "FAROES", "FINNSHEEP", "FUGLESTAD", "GADDI",
                    "GALICIAN", "GALWAY", "GANJIA", "GHEZEL", "GOTLAND", "GUIRRA", "GUTE", "HAMPSHIRE", "HAN", "HANZHONG",
                    "HARNAI", "HAZARAGIE", "HEBRIDEAN", "HEIDSCHNUCKE", "HERDWICK", "HERIK", "JACOB", "JURASCHAF", "KACHHI",
                    "KAJLI", "KAMAKUYRUK", "KARAKUL", "KARAYAKA", "KATAHDIN", "KIVIRCIK", "KOOKA", "KARAGOUNIKO", "LACAUNE", "LANDAIS",
                    "LANGHE", "LATI", "LATXA", "LEINESCHAF", "LINCOLN", "LLANWENOG", "LLEYN", "LOHI", "LONK", "MALTESE", "MANCHEGA",
                    "MANECH", "MARWARI", "MASAI", "MASHAM", "MEHRABAN", "MERINO", "MONTADALE", "NAJDI", "NALI", "NEWFOUNDLAND", "NELLORE",
                    "NILGIRI", "OULA", "ORKHON", "OSSIMI", "OUESSANT", "OXFORD", "PANAMA", "PERENDALE", "PINZIRITA", "POLWARTH",
                    "POLYPAY", "PORTLAND", "PRAMENKA", "PRIANGAN", "QASHQAI", "QIAOKE", "QUADRELLA", "RACKA", "RAMBOUILLET", "ROMANOV",
                    "ROSLAG", "RUDA", "RYA", "RYELAND", "RYGJA", "SAKIZ", "SARGIN", "SARDINIAN", "SERRAI", "SHETLAND", "SHROPSHIRE",
                    "SKUDDE", "SOAY", "SOMALI", "SOUTHDOWN", "STEINSCHAF", "SUFFOLK", "SUMAVSKA", "SWALEDALE", "SWIFTER", "TALESHI",
                    "TAN", "TARGHEE", "TAUTRA", "TEESWATER", "TEXEL", "THALLI", "WAZIRI", "WENSLEYDALE", "WILTIPOLL", "XALDA", "YANKASA",
                    "YIECHENG", "YOROO", "ZACKEL", "ZAGHAWA", "ZAIAN", "ZELAZNA", "ZEMMOUR", "ZLATUSHA", "ZOULAY", "ZWARTBLES");
        } else if (category == US_STATES) {
            return Arrays.asList("ALABAMA", "ALASKA", "ARIZONA", "ARKANSAS", "CALIFORNIA", "COLORADO", "CONNECTICUT", "DELAWARE", "FLORIDA", "GEORGIA",
                    "HAWAII", "IDAHO", "ILLINOIS", "INDIANA", "IOWA", "KANSAS", "KENTUCKY", "LOUISIANA", "MAINE", "MARYLAND", "MASSACHUSETTS", "MICHIGAN",
                    "MINNESOTA", "MISSISSIPPI", "MISSOURI", "MONTANA", "NEBRASKA", "NEVADA", "OHIO", "OKLAHOMA", "OREGON", "PENNSYLVANIA",
                    "TENNESSEE", "TEXAS", "UTAH", "VERMONT", "VIRGINIA", "WASHINGTON", "WISCONSIN", "WYOMING");
        } else if (category == WELSH_TOWNS) {
            return Arrays.asList("ABERAERON", "ABERAVON", "ABERBARGOED", "ABERCARN", "ABERDARE", "ABERFAN", "ABERGAVENNY", "ABERGELE", "ABERTILLERY",
                    "ABERYSTWYTH", "AMLWCH", "AMMANFORD", "BAGILLT", "BALA", "BANGOR", "BARGOED", "BARMOUTH", "BARRY", "BEAUMARIS", "BETHESDA", "BLAENAVON",
                    "BLACKWOOD", "BLAINA", "BRECON", "BRIDGEND", "BRYNMAWR", "BUCKLEY", "BLAENHONDDAN", "CAERLEON", "CAERNARFON", "CAERPHILLY", "CAERWYS", "CALDICOT",
                    "CARDIFF", "CARDIGAN", "CARMARTHEN", "CHEPSTOW", "CHIRK", "CONWY", "CORWEN", "COWBRIDGE", "CRICCIETH", "CRICKHOWELL", "CRUMLIN", "CWMAMMAN",
                    "CWMBRAN", "DENBIGH", "DOLGELLAU", "EWLOE", "FERNDALE", "FISHGUARD", "FLINT", "GELLIGAER", "GLYNNEATH", "GOODWICK", "GORSEINON", "GOWERTON",
                    "GRESFORD", "HARLECH", "HAVERFORDWEST", "HOLT", "HOLYHEAD", "HOLYWELL", "KIDWELLY", "KENFIG", "KNIGHTON", "LAMPETER", "LAUGHARNE", "LLANBERIS",
                    "LLANDEILO", "LLANDOVERY", "LLANDUDNO", "LLANDYSUL", "LLANELLI", "LLANFAIRFECHAN", "LLANGEFNI", "LLANGOLLEN", "LLANIDLOES", "LLANRWST",
                    "LLANSTEFFAN", "LLANTRISANT", "LLANYBYDDER", "LOUGHOR", "LLANDDULAS", "MACHYNLLETH", "MAESTEG", "MOLD", "MONMOUTH", "MONTGOMERY",
                    "NARBERTH", "NEATH", "NEFYN", "NEWBRIDGE", "NEWPORT", "NEWTOWN", "NEYLAND", "PEMBROKE", "PENARTH", "PENCOED", "PENMAENMAWR", "PONTARDAWE",
                    "PONTARDDULAIS", "PONTYCLUN", "PONTYPOOL", "PONTYPRIDD", "PORTH", "PORTHCAWL", "PORTHMADOG", "PRESTATYN", "PRESTEIGNE", "PWLLHELI", "PYLE",
                    "QUEENSFERRY", "RHAYADER", "RHOSLLANERCHRUGOG", "RHUDDLAN", "RHYL", "RHYMNEY", "RISCA", "RUTHIN", "SALTNEY", "SENGHENYDD", "SHOTTON", "SWANSEA",
                    "TALGARTH", "TENBY", "TONYPANDY", "TREDEGAR", "TREGARON", "TREHARRIS", "TYWYN", "USK", "WELSHPOOL", "WHITLAND", "WREXHAM", "YSTALYFERA", "YSTRADGYNLAIS");
        }
        return Arrays.asList();
    }

    public static WordList getCategory(Context context) {
        try {
            SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            String category = prefs.getString(CATEGORY_KEY, DINOSAURS.name());
            return valueOf(category);
        } catch (Exception e) {
            return DINOSAURS;
        }
    }

    public static void setCategory(Context context, WordList category) {
        if (category != null) {
            context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                    .edit()
                    .putString(CATEGORY_KEY, category.name())
                    .commit();
        }
    }

    public static int getCategoryDrawable(WordList category) {
        switch (category) {
            case AFRICAN_COUNTRIES:
                return R.drawable.africa;
            case BERRIES:
                return R.drawable.berries;
            case BRITISH_TREES:
                return R.drawable.british_trees;
            case CHESS_PIECES:
                return R.drawable.chess_pieces;
            case CONSTELLATIONS:
                return R.drawable.constellations;
            case DINOSAURS:
                return R.drawable.dinosaurs;
            case EGYPTIAN_GODS:
                return R.drawable.egyptian_gods;
            case EUROPEAN_CAPITALS:
                return R.drawable.european_capitals;
            case GREEK_PHILOSOPHERS:
                return R.drawable.greek_philosophers;
            case PERIODIC_TABLE:
                return R.drawable.periodic_table;
            case RENAISSANCE_ARTISTS:
                return R.drawable.renaissance_artists;
            case SHEEP_BREEDS:
                return R.drawable.sheep_breeds;
            case US_STATES:
                return R.drawable.us_states;
            case WELSH_TOWNS:
                return R.drawable.welsh_towns;
        }
        return R.drawable.dinosaurs;
    }

    public String getDisplayText() {
        return displayText;
    }
}
