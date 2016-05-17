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
                        Email = c.String(nullable: false),
                        Senha = c.String(nullable: false),
                        Nome = c.String(nullable: false),
                        Permissao_ID = c.Int(),
                    })
                .PrimaryKey(t => t.ID)
                .ForeignKey("dbo.Permissao", t => t.Permissao_ID)
                .Index(t => t.Permissao_ID);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Usuario", "Permissao_ID", "dbo.Permissao");
            DropIndex("dbo.Usuario", new[] { "Permissao_ID" });
            DropTable("dbo.Usuario");
            DropTable("dbo.Permissao");
        }
    }
}
