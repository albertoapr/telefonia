package mil.br.pamerj.projects.telefonia.model;

import mil.br.pamerj.projects.telefonia.dto.AdminUserDTO;

public class AdminUser {

    private Long id;
    private String login;

    public AdminUser() {
        super();
    }

    public AdminUser(AdminUserDTO dto) {
        fill(dto);
    }

    private void fill(AdminUserDTO dto) {
        if (dto != null) {
            id = dto.getId();
            login = dto.getLogin();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof AdminUser)) {
            return false;
        }
        AdminUser other = (AdminUser) object;
        if ((this.getId() == null && other.getId() != null)
                || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AdminUser[id=" + getId() + "]";
    }

    public AdminUserDTO createDTO() {
        AdminUserDTO dto = new AdminUserDTO();
        dto.setId(id);
        dto.setLogin(login);

        return dto;
    }
}
