public class Person {
    private int inn;
    private String firstName;
    private String lastName;
    private LocalDate dataBirth;
    @@ -17,7 +16,8 @@ public class Person {
        private Person husband;
        private HashSet<Person> children;


        public Person(String fName, String lName, Gender gen, LocalDate dataB, LocalDate dataM, int innP) {
            this.firstName = fName;
            this.lastName = lName;
            this.gender = gen;
            @@ -26,15 +26,25 @@ public Person(String fName, String lName, Gender gen, LocalDate dataB, LocalDate
            this.father = null;
            this.mother = null;
            children = new HashSet<>();
            this.inn = innP;
        }

        public Person(String fName, String lName, Gender gen, LocalDate dataB) {
            this(fName, lName, gen, dataB, null, 0);

        }

        public void setInn(int valueInn) {
            this.inn = valueInn;
        }

        public int getInn() {
            return this.inn;
        }

        //TODO доработать для одного родителя
        public void setParents(Person fParent, Person sParent) {
            if ((fParent != sParent) && (fParent.gender == sParent.gender)) {
                System.out.println("неверно указаны родители");
            } else {
                this.addParent(fParent);
                @@ -45,36 +55,35 @@ public void setParents(Person fParent, Person sParent) {
                }
            }

            public void setParents(Person Parent) {
                this.setParents (Parent, Parent);
            }

            private void addChildren(Person children) {

                this.children.add(children);
            }

            private void addParent(Person parent) {
                if ((this.mother == null)&&(parent.gender == Gender.Female)) {
                    this.mother = parent;
                }
                if ((this.father == null)&& (parent.gender == Gender.Male)) {
                    this.father = parent;
                }

            }

            public String getInfo() {
                return String.join(" ", this.firstName, this.lastName);
            }

            public String getFullInfo() {
                StringBuilder info = new StringBuilder();
                info.append("Full name: ");
                info.append(this.getInfo());
                info.append(", INN: ");
                info.append(this.inn);
                info.append(", date birth: ");
                info.append(this.dataBirth);
                if (!(this.dataMort == null)) {
                    @@ -83,11 +92,34 @@ public String getFullInfo() {
                    }
                    info.append(", parents: ");
                    info.append(this.getListParent());
                    info.append(",  husband: ");
                    info.append(this.husband != null ? this.husband.getInfo() : "NON");


                    return new String(info);
                }

                public String getString() {
                    StringBuilder info = new StringBuilder();
                    info.append(this.inn);
                    info.append(" ");
                    info.append(this.getInfo());
                    info.append(" ");
                    info.append(this.gender);
                    info.append(" ");
                    info.append(this.dataBirth);
                    info.append(" ");
                    info.append(this.dataMort);
                    info.append(" ");
                    info.append(this.father != null ? this.father.inn : "null");
                    info.append(" ");
                    info.append(this.mother != null ? this.mother.inn : "null");
                    info.append(" ");
                    info.append(this.husband != null ? this.husband.inn : "null");

                    return new String(info);
                }

                public HashSet<Person> getChildren() {
                    return this.children;

                    @@ -110,11 +142,13 @@ public String getListChildren() {


                        public String getListParent() {


                            StringBuilder info = new StringBuilder();
                            info.append("father: ");
                            info.append(this.father == null ? "unknown" : this.father.getInfo());
                            info.append(", mother: ");
                            info.append(this.mother == null ? "unknown" : this.mother.getInfo());

                            return new String(info);
                        }
                        @@ -131,6 +165,10 @@ public Person getMother() {
                            return this.mother;
                        }

                        public Person getHusband() {
                            return this.husband;
                        }


                        public boolean marriage(Person partner) {
                            if ((this.gender != partner.gender)
