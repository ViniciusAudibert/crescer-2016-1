namespace LojaNinja.Repositorio.ES.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Permissao",
                c => new
                    {
                        ID = c.Int(nullable: false, identity: true),
                        Permissoes = c.String(),
                    })
                .PrimaryKey(t => t.ID);
            
            CreateTable(
                "dbo.Usuario",
                c => new
                    {
                        ID = c.Int(nullable: false, identity: true),
                        Email = c.String(),
                        Senha = c.String(),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.ID);
            
            CreateTable(
                "dbo.UsuarioPermissao",
                c => new
                    {
                        Usuario_ID = c.Int(nullable: false),
                        Permissao_ID = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.Usuario_ID, t.Permissao_ID })
                .ForeignKey("dbo.Usuario", t => t.Usuario_ID, cascadeDelete: true)
                .ForeignKey("dbo.Permissao", t => t.Permissao_ID, cascadeDelete: true)
                .Index(t => t.Usuario_ID)
                .Index(t => t.Permissao_ID);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.UsuarioPermissao", "Permissao_ID", "dbo.Permissao");
            DropForeignKey("dbo.UsuarioPermissao", "Usuario_ID", "dbo.Usuario");
            DropIndex("dbo.UsuarioPermissao", new[] { "Permissao_ID" });
            DropIndex("dbo.UsuarioPermissao", new[] { "Usuario_ID" });
            DropTable("dbo.UsuarioPermissao");
            DropTable("dbo.Usuario");
            DropTable("dbo.Permissao");
        }
    }
}
